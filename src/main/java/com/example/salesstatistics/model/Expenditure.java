package com.example.salesstatistics.model;

import com.example.salesstatistics.model.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE expenditure SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Expenditure extends AbsEntity {
    private Date date;
    private Double expenditureAmount;
    private String reasonOfExpenditure;

    private Boolean deleted = false;

    public Expenditure(Date date, Double expenditure, String reasonOfExpenditure) {
        this.date = date;
        this.expenditureAmount = expenditure;
        this.reasonOfExpenditure = reasonOfExpenditure;
    }
}

