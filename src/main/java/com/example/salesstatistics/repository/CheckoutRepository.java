package com.example.salesstatistics.repository;

import com.example.salesstatistics.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
}

