package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository){

        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;

    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //Retrieve the Cart info from dto
        Cart cart = purchase.getCart();

        // Generate tracking info
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //Populate Cart with CartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        //Populate Cart with Customer
        //cart.setCartItems(purchase.getCartItems()); Redundant line
        cart.setCustomer(purchase.getCustomer());

        //Note: No need to populate cart with customer or add customer to repository so it has been commented out.
        //This causes issues (i.e. create_date and division_id of customer table turns to null
        //when purchase is completed if this code is in place

        //Populate Customer with Cart
        //Customer customer = purchase.getCustomer();
        // No need to add cart here since it's already set in the purchase object
        //customer.add(cart);


        //Save Customer to the database
        //customerRepository.save(customer);

        //Set Cart status to "ordered"
        cart.setStatus(Cart.StatusType.ordered);

        // Save Cart to the Database
        cartRepository.save(cart);

        //Return a response. Added validation to return "Cart Empty" to user if cart is empty
        if (cart.getCartItems() == null || cart.getCartItems().isEmpty()){
            return new PurchaseResponse("Cart Empty!");
        }
        else{
            return new PurchaseResponse(orderTrackingNumber);
        }

    }

    private String generateOrderTrackingNumber() {

        //Generate a random UUID (UUID-version 4)
        return UUID.randomUUID().toString();

    }
}
