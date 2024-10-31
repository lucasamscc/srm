package com.project.srm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cdcustomer")
    private Long cdCustomer;

    @ManyToOne
    @JoinColumn(name="cdcompany", nullable=false)
    private Company company;

    @ManyToOne
    @JoinColumn(name="cdcustomercategory")
    private CustomerCategory customerCategory;
}
