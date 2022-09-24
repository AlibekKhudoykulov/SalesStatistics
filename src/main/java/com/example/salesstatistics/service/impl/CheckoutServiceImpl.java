package com.example.salesstatistics.service.impl;

import com.example.salesstatistics.model.Checkout;
import com.example.salesstatistics.payload.ApiResponse;
import com.example.salesstatistics.repository.CheckoutRepository;
import com.example.salesstatistics.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {
    private final CheckoutRepository checkoutRepository;

    @Override
    public ApiResponse getAllCheckouts() {
        List<Checkout> all = checkoutRepository.findAll();
        return new ApiResponse("Success", true, all);
    }

    @Override
    public ApiResponse getCheckoutById(UUID id) {
        Checkout checkout = checkoutRepository.findById(id).orElseThrow(() -> new IllegalStateException("Checkout not found"));
        return new ApiResponse("Success", true, checkout);
    }

    @Override
    public ApiResponse createCheckout(String checkoutName) {
        Checkout checkout = new Checkout();
        checkout.setCheckoutName(checkoutName);
        Checkout save = checkoutRepository.save(checkout);
        return new ApiResponse("Success", true, save);
    }

    @Override
    public ApiResponse editCheckout(String checkoutName, UUID id) {
        Checkout checkout = checkoutRepository.findById(id).orElseThrow(() -> new IllegalStateException("Checkout not found"));
        checkout.setCheckoutName(checkoutName);
        Checkout save = checkoutRepository.save(checkout);
        return new ApiResponse("Success", true, save);
    }

    @Override
    public ApiResponse deleteCheckout(UUID id) {
        try {
            checkoutRepository.deleteById(id);
            return new ApiResponse("Success", true);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }
}
