package com.example.salesstatistics.controller;

import com.example.salesstatistics.constants.PathConstant;
import com.example.salesstatistics.payload.ApiResponse;
import com.example.salesstatistics.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(PathConstant.CHECKOUT)
@RequiredArgsConstructor
@CrossOrigin
public class CheckoutController {
    private final CheckoutService checkoutService;

    @GetMapping
    public ResponseEntity<ApiResponse> getCheckout() {
        ApiResponse allCheckouts = checkoutService.getAllCheckouts();
        return ResponseEntity.ok(allCheckouts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getCheckoutById(@PathVariable UUID id) {
        ApiResponse checkoutById = checkoutService.getCheckoutById(id);
        return ResponseEntity.ok(checkoutById);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> createCheckout(@RequestBody String checkoutName) {
        ApiResponse apiResponse = checkoutService.createCheckout(checkoutName);
        return ResponseEntity.ok(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editCheckout(@RequestBody String checkoutName, @PathVariable UUID id) {
        ApiResponse apiResponse = checkoutService.editCheckout(checkoutName, id);
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCheckout(@PathVariable UUID id) {
        ApiResponse apiResponse = checkoutService.deleteCheckout(id);
        return ResponseEntity.ok(apiResponse);
    }
}
