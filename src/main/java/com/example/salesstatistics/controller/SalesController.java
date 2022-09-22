package com.example.salesstatistics.controller;

import com.example.salesstatistics.constants.PathConstant;
import com.example.salesstatistics.payload.ApiResponse;
import com.example.salesstatistics.service.impl.SalesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathConstant.SALES)
@RequiredArgsConstructor
@CrossOrigin
public class SalesController {
    private final SalesServiceImpl salesService;

    @GetMapping
    public ResponseEntity<ApiResponse> getSales() {
        return ResponseEntity.ok(salesService.getAllSales());
    }
}
