package com.project.srm.dto;

import com.project.srm.model.Company;
import lombok.Data;

@Data
public class SupplierRequestDTO {
    private Company company;
    private Long cdSupplierCategory;
}
