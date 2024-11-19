package com.project.srm.service;

import com.project.srm.model.Company;
import com.project.srm.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElseThrow();
    }

    public List<Company> getCompanies() {
        return (List<Company>) companyRepository.findAll();
    }

    public Company saveCompany(Company company) {
        if (companyRepository.existsByIdCompany(company.getIdCompany())) {
            throw new RuntimeException("Company ID must be unique");
        }
        if (companyRepository.existsByTaxId(company.getIdTax())) {
            throw new RuntimeException("Tax ID must be unique");
        }
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public void updateCompany(Company company, Long id) {
        Company exist = companyRepository.findById(id).orElseThrow();
        exist.setIdCompany(company.getIdCompany());
        exist.setNmCompany(company.getNmCompany());
        exist.setPhone(company.getPhone());
        exist.setAddress(company.getAddress());
        exist.setIdTax(company.getIdTax());
        companyRepository.save(exist);
    }
}
