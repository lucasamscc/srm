package com.project.srm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cdcompany")
    private Long cdCompany;

    @Column(name="idcompany", nullable = false, unique = true)
    private String idCompany;

    @Column(name="nmcompany", nullable = false)
    private String nmCompany;

    @Column(name="idtax", nullable = false)
    private String idTax;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;
}
