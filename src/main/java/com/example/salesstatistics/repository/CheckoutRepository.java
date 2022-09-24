package com.example.salesstatistics.repository;

import com.example.salesstatistics.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CheckoutRepository extends JpaRepository<Checkout, UUID> {
}

