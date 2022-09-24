package com.example.salesstatistics.repository;

import com.example.salesstatistics.model.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {
}

