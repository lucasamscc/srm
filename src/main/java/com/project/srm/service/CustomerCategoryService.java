package com.project.srm.service;

import com.project.srm.model.CustomerCategory;
import com.project.srm.repository.CustomerCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerCategoryService {
    @Autowired
    private CustomerCategoryRepository customerCategoryRepository;

    public List<CustomerCategory> getCustomerCategories() {
        return customerCategoryRepository.findAll();
    }

    public CustomerCategory getById(Long id) {
        return customerCategoryRepository.findById(id).orElseThrow();
    }

    public void save (CustomerCategory supplierCategory) {
        customerCategoryRepository.save(supplierCategory);
    }

    public void deleteById(Long id) {
        customerCategoryRepository.deleteById(id);
    }

    public void updateSupplierCategory(CustomerCategory supplierCategory, Long id) {
        CustomerCategory exist = customerCategoryRepository.findById(id).orElseThrow();
        exist.setIdCustomerCategory(supplierCategory.getIdCustomerCategory());
        exist.setNmCustomerCategory(supplierCategory.getNmCustomerCategory());
        customerCategoryRepository.save(exist);
    }
}
