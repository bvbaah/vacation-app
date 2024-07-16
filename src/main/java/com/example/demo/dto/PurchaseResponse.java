package com.example.demo.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class PurchaseResponse {

    /*
    Use the annotation @NonNull to get rid of error for orderTrackingNumber in CheckoutService
    since PurchaseResponse expects zero arguments instead of 1.

    Using 'final' also works.
    */
    @NonNull
    private String orderTrackingNumber;
}
