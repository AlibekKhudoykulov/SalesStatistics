package com.example.salesstatistics.controller;

import com.example.salesstatistics.constants.PathConstant;
import com.example.salesstatistics.payload.ApiResponse;
import com.example.salesstatistics.payload.SalesDTO;
import com.example.salesstatistics.service.SalesService;
import com.example.salesstatistics.service.impl.SalesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(PathConstant.SALES)
@RequiredArgsConstructor
@CrossOrigin
public class SalesController {
    private final SalesServiceImpl salesService;

    @GetMapping
    public ResponseEntity<ApiResponse> getSales() {
        ApiResponse allSales = salesService.getAllSales();
        return new ResponseEntity<ApiResponse>(allSales, HttpStatus.OK);
    }

    @GetMapping("/{date}")

    public ResponseEntity<ApiResponse> getSalesByDate(@PathVariable String date) {
        ApiResponse salesByDate = salesService.getSalesByDate(date);
        return new ResponseEntity<ApiResponse>(salesByDate, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> createSales(@RequestBody SalesDTO salesDTO) {
        ApiResponse apiResponse = salesService.createSales(salesDTO);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editSales(@RequestBody SalesDTO salesDTO, @PathVariable UUID id) {
        ApiResponse apiResponse = salesService.editSales(salesDTO, id);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteSales(@PathVariable UUID id) {
        ApiResponse apiResponse = salesService.deleteSales(id);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }

}
