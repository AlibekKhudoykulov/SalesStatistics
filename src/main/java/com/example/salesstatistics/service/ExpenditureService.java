package com.example.salesstatistics.service;

import com.example.salesstatistics.payload.ApiResponse;
import com.example.salesstatistics.payload.ExpenditureDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public interface ExpenditureService {
    ApiResponse getAllExpenditures();
    ApiResponse getExpenditureById(UUID id);
    ApiResponse createExpenditure(ExpenditureDTO expenditureDTO);
    ApiResponse editExpenditure(ExpenditureDTO expenditureDTO, UUID id);
    ApiResponse deleteExpenditure(UUID id);
}
