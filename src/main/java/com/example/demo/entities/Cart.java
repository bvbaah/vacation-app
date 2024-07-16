package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter

public class Cart {


    //Create enum
    public enum StatusType{

        pending,
        ordered,
        canceled

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id; // Primary Key

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false) // Foreign Key - Many (Cart) to One (Customer)
    private Customer customer;

    @Column(name = "package_price")
    private BigDecimal package_price; //Used Double instead of double b/c Double type can be null which we need for database

    @Column(name = "party_size")
    private Integer party_size; // Used Integer instead of int because it can be set to null

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>(); //One (Cart) to Many (CartItem)

    //Enum annotation
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private StatusType status;

    public void add(CartItem item){
        if(item != null){
            if(cartItems == null){
                cartItems = new HashSet<>();
            }
            cartItems.add(item);
            item.setCart(this);
            }
        }
}

