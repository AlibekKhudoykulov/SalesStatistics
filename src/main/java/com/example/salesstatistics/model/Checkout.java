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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE checkout SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Checkout extends AbsEntity {

    private String checkoutName;

    private Boolean deleted = false;

    public Checkout(String checkoutName) {
        this.checkoutName = checkoutName;
    }
}
