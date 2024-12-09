package com.cardenascode.gestion_candidatos.infrastructure.rest.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CandidateResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String gender;
    private BigDecimal salaryExpected;

}
