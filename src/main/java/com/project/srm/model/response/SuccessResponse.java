package com.project.srm.model.response;

import lombok.Data;

@Data
public class SuccessResponse {
    private String message;

    public SuccessResponse(String message) {
        this.message = message;
    }
}
