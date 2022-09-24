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
public class ExpenditureDTO {
    private Date date;
    private Double expenditureAmount;
    private String reasonOfExpenditure;


}

