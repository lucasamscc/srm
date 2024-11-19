package com.project.srm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="suppliercategory")
public class SupplierCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cdsuppliercategory")
    private Long cdSupplierCategory;

    @Column(name="idsuppliercategory", nullable = false)
    private String idSupplierCategory;

    @Column(name="nmsuppliercategory", nullable = false)
    private String nmSupplierCategory;
}
