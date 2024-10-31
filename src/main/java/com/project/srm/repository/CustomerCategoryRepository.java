package com.project.srm.repository;

import com.project.srm.model.CustomerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCategoryRepository extends JpaRepository<CustomerCategory, Long> {
}
