package com.project.srm.service;

import com.project.srm.dto.EvaluationRequestDTO;
import com.project.srm.exception.ResourceNotFoundException;
import com.project.srm.model.Contact;
import com.project.srm.model.Evaluation;
import com.project.srm.model.Supplier;
import com.project.srm.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private SupplierService supplierService;

    public List<Evaluation> getEvaluations() {
        return (List<Evaluation>) evaluationRepository.findAll();
    }

    public Evaluation getEvaluation(Long id) {
        return evaluationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Avaliação não encontrada"));
    }

    public Evaluation saveEvaluation(EvaluationRequestDTO evaluationRequestDTO, Long cdSupplier) {
        Evaluation evaluation = new Evaluation();
        evaluation.setScore(evaluationRequestDTO.getScore());
        evaluation.setDate(evaluationRequestDTO.getDate());
        evaluation.setComment(evaluationRequestDTO.getComment());

        Supplier supplier = supplierService.getSupplier(cdSupplier);
        evaluation.setSupplier(supplier);

        return evaluationRepository.save(evaluation);
    }

    public Evaluation updateEvaluation(Long id, EvaluationRequestDTO evaluationRequestDTO) {
         Evaluation exist = evaluationRepository.findById(id).orElseThrow(() ->
                 new ResourceNotFoundException("Avaliação não encontrada"));
         exist.setScore(evaluationRequestDTO.getScore());
         exist.setDate(evaluationRequestDTO.getDate());
         exist.setComment(evaluationRequestDTO.getComment());

         return evaluationRepository.save(exist);
    }

    public void deleteEvaluation(Long id) {
        Evaluation evaluation = evaluationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliação não encontrada"));
        evaluationRepository.delete(evaluation);
    }
}
