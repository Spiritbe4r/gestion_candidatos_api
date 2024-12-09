package com.cardenascode.gestion_candidatos.infrastructure.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


@Schema(description = "Datos para registrar un candidato")

public record CandidateRequestDTO(
        @Schema(description = "Nombre del candidato", example = "John Doe")
        @NotBlank
        String name,

        @Schema(description = "Correo electrónico del candidato", example = "johndoe@example.com")
        @NotBlank
        String email,

        @Schema(description = "Género del candidato", example = "Male")
        @NotBlank
        String gender,

        @Schema(description = "Salario esperado del candidato", example = "50000")
        @NotNull
        BigDecimal salaryExpected

) {


}
