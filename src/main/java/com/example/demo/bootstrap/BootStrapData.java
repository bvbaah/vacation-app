package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {


        if(customerRepository.count() == 1){

            //Create new division

            Division d1 = divisionRepository.findById(4L).orElse(null);

            //Create Customer 1
            //d1 is added to the customer here. No need to create a Set of divisions in the Customer entity since each Customer can only be from one division - @ManyToOne: Many (Customers, One (Division)
            Customer john = new Customer(d1, "John", "Smith", "123 Maple Avenue", "10001", "(555) 123-4567");

            //Add customer 1 to the division's set of customers (a division can have many customers - @ManyToOne relationship)
            d1.getCustomers().add(john);

            customerRepository.save(john);

            //Create Customer 2
            //d1 is added to the customer here. No need to create a Set of divisions in the Customer entity since each Customer can only be from one division - @ManyToOne: Many (Customers, One (Division)
            Customer mary = new Customer(d1, "Mary", "Johnson", "456 Elm Street", "90210", "(555) 987-6543");

            //Add customer 2 to the division's set of customers (a division can have many customers - @ManyToOne relationship)
            d1.getCustomers().add(mary);

            //divisionRepository.save(d2);
            customerRepository.save(mary);

            //Create Customer 3
            //d1 is added to the customer here. No need to create a Set of divisions in the Customer entity since each Customer can only be from one division - @ManyToOne: Many (Customers, One (Division)
            Customer david = new Customer(d1, "David", "Williams", "789 Oak Drive", "60610", "(555) 555-1212");

            //Add customer 3 to the division's set of customers (a division can have many customers - @ManyToOne relationship)
            d1.getCustomers().add(david);

            //divisionRepository.save(d3);
            customerRepository.save(david);

            //Create Customer 4
            //d1 is added to the customer here. No need to create a Set of divisions in the Customer entity since each Customer can only be from one division - @ManyToOne: Many (Customers, One (Division)
            Customer sarah = new Customer(d1,"Sarah", "Brown", "101 Pine Road", "02130", "(555) 888-9999");

            //Add customer 1 to the division's set of customers (a division can have many customers - @ManyToOne relationship)
            d1.getCustomers().add(sarah);

            //divisionRepository.save(d4);
            customerRepository.save(sarah);

            //Create Customer 5
            //d1 is added to the customer here. No need to create a Set of divisions in the Customer entity since each Customer can only be from one division - @ManyToOne: Many (Customers, One (Division)
            Customer michael = new Customer(d1,"Michael", "Jones", "202 Cedar Lane", "33139", "(555) 444-3333");

            //Add customer 5 to the division's set of customers (a division can have many customers - @ManyToOne relationship)
            d1.getCustomers().add(michael);

            //divisionRepository.save(d5);
            customerRepository.save(michael);

            //Print out number of customers and divisions for debugging

            System.out.println("Started in Bootstrap.");
            System.out.println("Number of customers: " + customerRepository.count());
            System.out.println("Number of divisions: " + divisionRepository.count());
        }

    }
}
