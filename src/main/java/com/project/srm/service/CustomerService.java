package com.project.srm.service;

import com.project.srm.model.*;
import com.project.srm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerCategoryService customerCategoryService;

    @Autowired
    private CompanyService companyService;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    public void saveCustomer(Company company, Long cdCustomerCategory) {
        Company savedCompany = companyService.saveCompany(company);
        CustomerCategory customerCategory = customerCategoryService.getById(cdCustomerCategory);

        Customer customer = new Customer();
        customer.setCompany(savedCompany);
        customer.setCustomerCategory(customerCategory);
        customerRepository.save(customer);
    }
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
