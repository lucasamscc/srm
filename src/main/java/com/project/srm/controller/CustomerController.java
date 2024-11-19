package com.project.srm.controller;

import com.project.srm.dto.CustomerRequestDTO;
import com.project.srm.model.Company;
import com.project.srm.model.Customer;
import com.project.srm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        Company company = customerRequestDTO.getCompany();
        Long cdCustomerCategory = customerRequestDTO.getCdCustomerCategory();
        customerService.saveCustomer(company, cdCustomerCategory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
