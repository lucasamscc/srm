package com.project.srm.controller;

import com.project.srm.model.CustomerCategory;
import com.project.srm.service.CustomerCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerCategories")
public class CustomerCategoryController {
    @Autowired
    private CustomerCategoryService customerCategoryService;

    @GetMapping
    public List<CustomerCategory> getCustomerCategories() {
        return customerCategoryService.getCustomerCategories();
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerCategory> getCustomerCategoryById(@PathVariable Long id) {
        CustomerCategory byId = customerCategoryService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerCategory> updateCustomerCategory(@RequestBody CustomerCategory customerCategory, @PathVariable Long id) {
        customerCategoryService.updateSupplierCategory(customerCategory, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<CustomerCategory> saveCustomerCategory(@RequestBody CustomerCategory supplierCategory) {
        customerCategoryService.save(supplierCategory);
        return new ResponseEntity<>(supplierCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CustomerCategory> deleteCustomerCategory(@PathVariable Long id) {
        customerCategoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
