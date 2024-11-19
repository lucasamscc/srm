package com.project.srm.service;

import com.project.srm.model.Company;
import com.project.srm.model.Supplier;
import com.project.srm.model.SupplierCategory;
import com.project.srm.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private SupplierCategoryService supplierCategoryService;

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplier(Long id) {
        return supplierRepository.findById(id).orElseThrow();
    }

    public void saveSupplier(Company company, Long cdSupplierCategory) {
        Company savedCompany = companyService.saveCompany(company);
        SupplierCategory supplierCategory = supplierCategoryService.getById(cdSupplierCategory);

        Supplier supplier = new Supplier();
        supplier.setCompany(savedCompany);
        supplier.setSupplierCategory(supplierCategory);
        supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
