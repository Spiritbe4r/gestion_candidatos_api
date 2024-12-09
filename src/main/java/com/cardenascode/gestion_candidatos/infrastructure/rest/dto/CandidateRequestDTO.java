package com.cardenascode.gestion_candidatos.infrastructure.rest.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;



@Getter
@Setter
@Schema(description = "Datos para registrar un candidato")
public class CandidateRequestDTO {

    @Schema(description = "Nombre del candidato", example = "John Doe")
    @NotBlank
    private String name;

    @Schema(description = "Correo electrónico del candidato", example = "johndoe@example.com")
    @NotBlank
    private String email;

    @Schema(description = "Género del candidato", example = "Male")
    @NotBlank
    private String gender;

    @Schema(description = "Salario esperado del candidato", example = "50000")
    @NotNull
    private BigDecimal salaryExpected;

}
