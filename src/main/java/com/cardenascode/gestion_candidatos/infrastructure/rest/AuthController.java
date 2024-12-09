package com.cardenascode.gestion_candidatos.infrastructure.rest;

import com.cardenascode.gestion_candidatos.application.service.AuthService;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.AuthResponseDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.LoginDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.RegisterRequestDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
@Tag(name = "Authentication", description = "Endpoints para autenticación y registro de usuarios")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authFacade) {
        this.authService = authFacade;
    }

    @Operation(summary = "Registrar un usuario", description = "Permite registrar un nuevo usuario con credenciales válidas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario registrado con éxito", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = UserResponseDTO.class)
            )),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud"),
            @ApiResponse(responseCode = "409", description = "Usuario con ese email ya Existe"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping(value = "/register")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody RegisterRequestDTO request) {
        var result = authService.register(request);
        return ResponseEntity.ok().body(result);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autenticación exitosa"),
            @ApiResponse(responseCode = "401", description = "Credenciales inválidas"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO request) {
        var result = authService.login(request);
        return ResponseEntity.ok().body(result);
    }
}