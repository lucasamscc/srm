package com.project.srm.controller;

import com.project.srm.dto.EvaluationRequestDTO;
import com.project.srm.model.Evaluation;
import com.project.srm.model.response.SuccessResponse;
import com.project.srm.service.EvaluationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("{cdSupplier}/evaluations")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @GetMapping
    public List<Evaluation> getEvaluations(@PathVariable String cdSupplier) {
        return evaluationService.getEvaluations();
    }

    @GetMapping("{id}")
    public ResponseEntity<Evaluation> getEvaluation(@PathVariable Long id, @PathVariable String cdSupplier) {
        Evaluation byId = evaluationService.getEvaluation(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<Evaluation> createEvaluation(@RequestBody @Valid EvaluationRequestDTO evaluationRequestDTO, @PathVariable Long cdSupplier) {
        Evaluation savedEvaluation = evaluationService.saveEvaluation(evaluationRequestDTO, cdSupplier);
        return new ResponseEntity<>(savedEvaluation, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SuccessResponse> deleteEvaluation(@PathVariable Long id) {
        evaluationService.deleteEvaluation(id);
        SuccessResponse response = new SuccessResponse("Avaliação excluída com sucessp");
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Void> updateEvaluation(@RequestBody @Valid EvaluationRequestDTO evaluationRequestDTO, @PathVariable Long id) {
        evaluationService.updateEvaluation(id, evaluationRequestDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
