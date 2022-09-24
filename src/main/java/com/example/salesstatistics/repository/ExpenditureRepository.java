package com.example.salesstatistics.repository;

import com.example.salesstatistics.model.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpenditureRepository extends JpaRepository<Expenditure, UUID> {
}

