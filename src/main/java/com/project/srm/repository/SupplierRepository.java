package com.project.srm.repository;

import com.project.srm.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    boolean existsBySupplierCategory_CdSupplierCategory(Long cdSupplierCategory);
}
