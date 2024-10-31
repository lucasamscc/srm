package com.project.srm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="customercategory")
public class CustomerCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cdcustomercategory")
    private Long cdCustomerCategory;

    @Column(name="idcustomercategory", nullable = false)
    private String idCustomerCategory;

    @Column(name="nmcustomercategory", nullable = false)
    private String nmCustomerCategory;
}
