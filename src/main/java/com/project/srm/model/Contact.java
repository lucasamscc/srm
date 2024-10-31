package com.project.srm.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cdcontact")
    private Long cdContact;

    @ManyToOne
    @JoinColumn(name = "cdcompany", nullable = false)
    private Company company;

    @Column(name="nmcontact", nullable = false)
    private String nmContact;

    @Column(name="role")
    private String role;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="description")
    private String description;
}
