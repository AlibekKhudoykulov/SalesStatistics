package com.example.salesstatistics.service;

import com.example.salesstatistics.payload.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface CheckoutService {
    ApiResponse getAllCheckouts();
    ApiResponse getCheckoutById(UUID id);
    ApiResponse createCheckout(String checkoutName);
    ApiResponse editCheckout(String checkoutName, UUID id);
    ApiResponse deleteCheckout(UUID id);

}
