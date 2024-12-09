package com.cardenascode.gestion_candidatos.infrastructure.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos de Respuesta del Login")
public record AuthResponseDTO (
        @Schema(description = "token de Autenticación", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnYXRpdG8yQGdtYWlsLmNvbSIsImlhdCI6MTczMzcyNjY0NywiZXhwIjoxNzMzNzMwMjQ3fQ._N7nbwmUB_zwyxtscL4xA4Laxg6oieDcm_GmVSthyGWAHbrqRS1bJH2XDxgFTjRpDGwhiOm9hOzjqX2wfTxfXA")
        String token){
}
