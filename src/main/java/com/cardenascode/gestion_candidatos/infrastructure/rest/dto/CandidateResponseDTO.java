package com.cardenascode.gestion_candidatos.infrastructure.rest.dto;


import java.math.BigDecimal;


public record CandidateResponseDTO(
        Long id,
        String name,
        String email,
        String gender,
        BigDecimal salaryExpected
) {


}
