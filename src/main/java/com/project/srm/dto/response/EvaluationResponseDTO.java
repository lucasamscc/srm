package com.project.srm.dto.response;

import com.project.srm.model.Evaluation;
import lombok.Data;

import java.util.Date;

@Data
public class EvaluationResponseDTO {
    private Long cdEvaluation;
    private Long supplierId;
    private Integer score;
    private String comment;
    private Date date;

    public EvaluationResponseDTO(Evaluation evaluation) {
        this.cdEvaluation = evaluation.getCdEvaluation();
        this.supplierId = evaluation.getSupplier().getCdSupplier();
        this.score = evaluation.getScore();
        this.comment = evaluation.getComment();
        this.date = evaluation.getDate();
    }
}