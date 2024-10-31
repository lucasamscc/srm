package com.project.srm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cdsupplier")
    private Long cdSupplier;

    @ManyToOne
    @JoinColumn(name="cdcompany", nullable=false)
    private Company company;

    @ManyToOne
    @JoinColumn(name="cdsuppliercategory")
    private SupplierCategory supplierCategory;
}
