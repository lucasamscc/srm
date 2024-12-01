package com.project.srm.service;

import com.project.srm.exception.ResourceNotFoundException;
import com.project.srm.model.SupplierCategory;
import com.project.srm.repository.SupplierCategoryRepository;
import com.project.srm.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierCategoryService {
    @Autowired
    private SupplierCategoryRepository supplierCategoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierCategory> getSupplierCategories() {
        return supplierCategoryRepository.findAll();
    }

    public SupplierCategory getById(Long id) {
        return supplierCategoryRepository.findById(id).orElseThrow();
    }

    public void save (SupplierCategory supplierCategory) {
        supplierCategoryRepository.save(supplierCategory);
    }

    public void deleteById(Long id) {
        supplierCategoryRepository.deleteById(id);
    }

    public void updateSupplierCategory(SupplierCategory supplierCategory, Long id) {
        // Verificar se a categoria de fornecedor existe
        SupplierCategory exist = supplierCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria de fornecedor não encontrada"));

        // Verificar se a categoria está associada a algum registro
        boolean isCategoryUsed = supplierRepository.existsBySupplierCategory_CdSupplierCategory(id);  // Método correto

        if (isCategoryUsed) {
            // Se a categoria estiver associada, lançar exceção com mensagem personalizada
            throw new ResourceNotFoundException("A categoria de fornecedor não pode ser alterada, pois está associada a registros existentes.");
        }

        // Se não estiver associada, podemos proceder com o update
        exist.setIdSupplierCategory(supplierCategory.getIdSupplierCategory());
        exist.setNmSupplierCategory(supplierCategory.getNmSupplierCategory());

        // Salvar a categoria atualizada
        supplierCategoryRepository.save(exist);
    }

}
