package com.project.srm.controller;

import com.project.srm.model.SupplierCategory;
import com.project.srm.service.SupplierCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplierCategories")
public class SupplierCategoryController {
    @Autowired
    private SupplierCategoryService supplierCategoryService;

    @GetMapping
    public List<SupplierCategory> getAllSupplierCategories() {
        return supplierCategoryService.getSupplierCategories();
    }

    @GetMapping("{id}")
    public ResponseEntity<SupplierCategory> getSupplierCategoryById(@PathVariable Long id) {
        SupplierCategory byId = supplierCategoryService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PutMapping("{id}")
    public ResponseEntity<SupplierCategory> updateSupplierCategory(@RequestBody SupplierCategory supplierCategory, @PathVariable Long id) {
        supplierCategoryService.updateSupplierCategory(supplierCategory, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<SupplierCategory> saveSupplierCategory(@RequestBody SupplierCategory supplierCategory) {
        supplierCategoryService.save(supplierCategory);
        return new ResponseEntity<>(supplierCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SupplierCategory> deleteSupplierCategory(@PathVariable Long id) {
        supplierCategoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
