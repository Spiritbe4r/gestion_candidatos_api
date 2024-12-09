package com.cardenascode.gestion_candidatos.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank
        String email,
        @NotBlank String password) {


}
