package com.example.salesstatistics.model;

import com.example.salesstatistics.model.template.AbsEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
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

        @ManyToOne
        private Checkout checkout;

        private Double income;


        private Boolean deleted = false;

        public Sales(Date date, Checkout checkout, Double income) {
                this.date = date;
                this.checkout = checkout;
                this.income = income;
        }
}


