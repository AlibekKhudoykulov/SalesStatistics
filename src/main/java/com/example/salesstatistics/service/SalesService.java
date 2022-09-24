package com.example.salesstatistics.service;

import com.example.salesstatistics.payload.ApiResponse;
import com.example.salesstatistics.payload.SalesDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public interface SalesService {
    ApiResponse getAllSales();
    ApiResponse getSalesByDate(String date);
//    ApiResponse getSalesByDateAndCheckoutName(String date, String checkoutName);
    ApiResponse createSales(SalesDTO salesDTO);
    ApiResponse editSales(SalesDTO salesDTO, UUID id);
    ApiResponse deleteSales(UUID id);

}
