package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
//@Data --> Does not work. Must use @Getter and @Setter. Lombok will handle the rest.
@Getter
@Setter
@NoArgsConstructor

// Implemented validation by adding nullable = false to all fields that require user input
public class Customer {

    public Customer(Division division, String firstName, String lastName, String address, String postal_code, String phone) {
        this.division = division;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
        this.carts = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id; //Primary Key

    @ManyToOne
    @JoinColumn(name = "division_id") // Foreign Key - Many (Customer) to One (Division)
    private Division division;

    @Column(name = "customer_first_name")
    private String firstName;

    @Column(name = "customer_last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "phone")
    private String phone;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts; //One (Customer) to Many (Cart)

    // Added this method to add a singular cart to a set of carts.
    public void add(Cart cart){
        if(cart != null){
            if(carts == null){
                carts = new HashSet<>();
            }
            carts.add(cart);
            //Set this customer to the cart
            cart.setCustomer(this);


        }
    }

}
