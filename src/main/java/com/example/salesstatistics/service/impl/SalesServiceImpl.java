package com.example.salesstatistics.service.impl;

import com.example.salesstatistics.model.Sales;
import com.example.salesstatistics.payload.ApiResponse;
import com.example.salesstatistics.payload.SalesDTO;
import com.example.salesstatistics.repository.SalesRepository;
import com.example.salesstatistics.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;

    @Override
    public ApiResponse getSalesByDate(String date) {
        List<Sales> allByDate = salesRepository.findAllByDate(date);
        return new ApiResponse("Success", true, allByDate);
    }

    @Override
    public ApiResponse getSalesByDateAndCheckoutName(String date, String checkoutName) {
        List<Sales> allByDateAndCheckoutName = salesRepository.findAllByDateAndCheckoutName(date, checkoutName);
        return new ApiResponse("Success", true, allByDateAndCheckoutName);
    }

    @Override
    public ApiResponse createSales(SalesDTO salesDTO) {
        Sales sales = new Sales();
        sales.setDate(salesDTO.getDate());
        sales.setIncome(salesDTO.getIncome());
        salesRepository.save(sales);
        return new ApiResponse("Success", true);
    }

    @Override
    public ApiResponse editSales(SalesDTO salesDTO, UUID id) {
        Sales sales = salesRepository.findById(id).orElseThrow(() -> new IllegalStateException("Sales not found"));


        salesRepository.save(sales);

        return new ApiResponse("Success", true);
    }

    @Override
    public ApiResponse deleteSales(UUID id) {
        try {
            salesRepository.deleteById(id);
            return new ApiResponse("Success", true);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }

    @Override
    public ApiResponse getAllSales() {
        List<Sales> all = salesRepository.findAll();
        return new ApiResponse("Success", true, all);
    }
}

