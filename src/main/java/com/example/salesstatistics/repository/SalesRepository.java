package com.example.salesstatistics.repository;

import com.example.salesstatistics.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalesRepository extends JpaRepository<Sales, UUID> {

}
