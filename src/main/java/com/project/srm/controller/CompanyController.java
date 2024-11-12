package com.project.srm.controller;

import com.project.srm.model.Company;
import com.project.srm.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        Company byId = companyService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping
    public List<Company> getCompanies() {
        return companyService.getAll();
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Company company) {
        companyService.saveCompany(company);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody Company company, @PathVariable Long id) {
        companyService.updateCompany(company, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        companyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
