package com.project.srm.service;

import com.project.srm.model.SupplierCategory;
import com.project.srm.repository.SupplierCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierCategoryService {
    @Autowired
    private SupplierCategoryRepository supplierCategoryRepository;

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
        SupplierCategory exist = supplierCategoryRepository.findById(id).orElseThrow();
        exist.setIdSupplierCategory(supplierCategory.getIdSupplierCategory());
        exist.setNmSupplierCategory(supplierCategory.getNmSupplierCategory());
        supplierCategoryRepository.save(exist);
    }
}
