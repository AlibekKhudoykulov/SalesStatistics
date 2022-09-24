package com.example.salesstatistics.controller;

import com.example.salesstatistics.constants.PathConstant;
import com.example.salesstatistics.payload.ApiResponse;
import com.example.salesstatistics.payload.ExpenditureDTO;
import com.example.salesstatistics.service.ExpenditureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(PathConstant.EXPENDITURE)
@RequiredArgsConstructor
@CrossOrigin
public class ExpenditureController {
    private final ExpenditureService expenditureService;

    @GetMapping
    public ResponseEntity<ApiResponse> getExpenditure() {
        ApiResponse allExpenditure = expenditureService.getAllExpenditures();
        return ResponseEntity.ok(allExpenditure);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getExpenditureById(@PathVariable UUID id) {
        ApiResponse expenditureById = expenditureService.getExpenditureById(id);
        return ResponseEntity.ok(expenditureById);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> createExpenditure(@RequestBody ExpenditureDTO expenditureDTO) {
        ApiResponse apiResponse = expenditureService.createExpenditure(expenditureDTO);
        return ResponseEntity.ok(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editExpenditure(@RequestBody ExpenditureDTO expenditureDTO, @PathVariable UUID id) {
        ApiResponse apiResponse = expenditureService.editExpenditure(expenditureDTO, id);
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteExpenditure(@PathVariable UUID id) {
        ApiResponse apiResponse = expenditureService.deleteExpenditure(id);
        return ResponseEntity.ok(apiResponse);
    }
}
