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

    public Company getById(Long id) {
        return companyRepository.findById(id).orElseThrow();
    }

    public List<Company> getAll() {
        return (List<Company>) companyRepository.findAll();
    }

    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    public void deleteById(Long id) {
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
