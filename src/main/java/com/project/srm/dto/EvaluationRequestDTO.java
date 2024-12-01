package com.project.srm.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class EvaluationRequestDTO {
    @NotNull(message = "Avaliação é obrigatória!")
    @Min(value = 0, message = "A pontuação mínima permitida é 0!")
    @Max(value = 10, message = "A pontuação máxima permitida é 10!")
    private Integer score;

    private Date date;
    private String comment;
}
