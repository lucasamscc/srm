package com.project.srm.dto;

import com.project.srm.model.Company;
import lombok.Data;

@Data
public class CustomerRequestDTO {
    private Company company;
    private Long cdCustomerCategory;
}
