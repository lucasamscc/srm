package com.project.srm.repository;

import com.project.srm.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    boolean existsByIdCompany(String idCompany);

    default boolean existsByTaxId(String idTax) {
        return false;
    }
}
