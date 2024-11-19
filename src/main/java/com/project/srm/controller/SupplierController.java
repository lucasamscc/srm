package com.project.srm.controller;

import com.project.srm.dto.SupplierRequestDTO;
import com.project.srm.model.Company;
import com.project.srm.model.Supplier;
import com.project.srm.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getSuppliers() {
        return supplierService.getSuppliers();
    }

    @GetMapping("{id}")
    public Supplier getSupplier(@PathVariable Long id) {
        return supplierService.getSupplier(id);
    }

    @PostMapping
    public ResponseEntity<Supplier> saveSupplier(@RequestBody SupplierRequestDTO supplierRequestDTO) {
        Company company = supplierRequestDTO.getCompany();
        Long cdSupplierCategory = supplierRequestDTO.getCdSupplierCategory();
        supplierService.saveSupplier(company, cdSupplierCategory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
