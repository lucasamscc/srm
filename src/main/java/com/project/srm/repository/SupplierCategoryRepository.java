package com.project.srm.repository;

import com.project.srm.model.SupplierCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierCategoryRepository extends JpaRepository<SupplierCategory, Long> {
}
