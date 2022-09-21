package com.example.salesstatistics.model;

import com.example.salesstatistics.model.template.AbsEntity;
import lombok.*;
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
@SQLDelete(sql = "UPDATE sales SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Sales extends AbsEntity {

        private Date date;

        private String checkoutName;

        private Double income;

        private Double expenditure;

        private String reasonOfExpenditure;

        private Boolean deleted = false;
}


