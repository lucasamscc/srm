package com.project.srm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cdevaluation")
    private Long cdEvaluation;

    @ManyToOne
    @JoinColumn(name="cdsupplier", nullable = false)
    private Supplier supplier;

    @Column(name="score", nullable = false)
    private Integer score;

    @Column(name="comment", nullable = false)
    private String comment;

    @Column(name="date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
}
