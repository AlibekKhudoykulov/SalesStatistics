package com.example.salesstatistics.service.impl;

import com.example.salesstatistics.model.Expenditure;
import com.example.salesstatistics.payload.ApiResponse;
import com.example.salesstatistics.payload.ExpenditureDTO;
import com.example.salesstatistics.repository.ExpenditureRepository;
import com.example.salesstatistics.service.ExpenditureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpenditureServiceImpl implements ExpenditureService {
    private final ExpenditureRepository expenditureRepository;

    @Override
    public ApiResponse getAllExpenditures() {
        List<Expenditure> all = expenditureRepository.findAll();
        return new ApiResponse("Success", true, all);
    }

    @Override
    public ApiResponse getExpenditureById(UUID id) {
        Expenditure expenditure = expenditureRepository.findById(id).orElseThrow(() -> new IllegalStateException("Expenditure not found"));
        return new ApiResponse("Success", true, expenditure);
    }

    @Override
    public ApiResponse createExpenditure(ExpenditureDTO expenditureDTO) {
        Expenditure expenditure = new Expenditure();
        expenditure.setDate(expenditureDTO.getDate());
        expenditure.setReasonOfExpenditure(expenditureDTO.getReasonOfExpenditure());
        expenditure.setExpenditureAmount(expenditureDTO.getExpenditureAmount());
        Expenditure save = expenditureRepository.save(expenditure);
        return new ApiResponse("Success", true, save);
    }

    @Override
    public ApiResponse editExpenditure(ExpenditureDTO expenditureDTO, UUID id) {
        Expenditure expenditure = expenditureRepository.findById(id).orElseThrow(() -> new IllegalStateException("Expenditure not found"));
        expenditure.setDate(expenditureDTO.getDate());
        expenditure.setReasonOfExpenditure(expenditureDTO.getReasonOfExpenditure());
        expenditure.setExpenditureAmount(expenditureDTO.getExpenditureAmount());
        Expenditure save = expenditureRepository.save(expenditure);
        return new ApiResponse("Success", true, save);
    }

    @Override
    public ApiResponse deleteExpenditure(UUID id) {
        try {
            expenditureRepository.deleteById(id);
            return new ApiResponse("Success", true);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }
}
