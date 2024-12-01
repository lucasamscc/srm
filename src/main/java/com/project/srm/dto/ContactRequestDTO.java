package com.project.srm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ContactRequestDTO {
    @NotEmpty(message = "Nome do contato é obrigatório!")
    private String nmContact;

    @NotEmpty(message = "E-mail é obrigatório!")
    @Email
    private String email;

    private String role;
    private String phone;
    private String description;
}
