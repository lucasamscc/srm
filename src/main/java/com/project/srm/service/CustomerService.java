package com.project.srm.service;

import com.project.srm.model.Company;
import com.project.srm.model.Customer;
import com.project.srm.model.CustomerCategory;
import com.project.srm.repository.CustomerCategoryRepository;
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

    public void saveCustomer(Customer customer, Long companyId, Long customerCategoryId) {
        Company company = companyService.getCompany(companyId);
        CustomerCategory customerCategory = customerCategoryService.getById(customerCategoryId);
        customer.setCompany(company);
        customer.setCustomerCategory(customerCategory);
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
