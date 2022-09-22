package com.example.salesstatistics.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesDTO {
    private Date date;

    private String checkoutName;

    private Double income;

    private Double expenditure;

    private String reasonOfExpenditure;
}
