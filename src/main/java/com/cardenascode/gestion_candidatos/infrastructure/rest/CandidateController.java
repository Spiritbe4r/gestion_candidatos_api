package com.cardenascode.gestion_candidatos.infrastructure.rest;

import com.cardenascode.gestion_candidatos.application.service.CandidateService;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.CandidateRequestDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.CandidateResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/candidates")
@Tag(name = "Candidates", description = "Endpoints para gestionar candidatos")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    @Operation(summary = "Crear un candidato", description = "Permite registrar un nuevo candidato.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Candidato creado con éxito"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud"),
            @ApiResponse(responseCode = "401", description = "Acceso no autorizado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<CandidateResponseDTO> createCandidate(@RequestBody CandidateRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidateService.createCandidate(request));
    }

    @GetMapping
    @Operation(summary = "Obtener todos los candidatos", description = "Devuelve una lista de todos los candidatos registrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidato creado con éxito"),
            @ApiResponse(responseCode = "401", description = "Acceso no autorizado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<List<CandidateResponseDTO>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }

    @PutMapping("{id}")
    @Operation(summary = "Actualizar candidatos", description = "Actualiza los datos del Usuario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Candidato creado con éxito"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud"),
            @ApiResponse(responseCode = "401", description = "Acceso no autorizado"),
            @ApiResponse(responseCode = "409", description = "Candidato ya Existe"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<CandidateResponseDTO> updateCandidate(@PathVariable Long id, @RequestBody CandidateRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK).body(candidateService.updateCandidate(id, request));
    }

    @GetMapping("{id}")
    @Operation(summary = "consultar candidato por id", description = "Devuelve un candidato registrado desde la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Candidato Consultado con éxito"),
            @ApiResponse(responseCode = "404", description = "Candidato con ese Id no existe o fue eliminado"),
            @ApiResponse(responseCode = "401", description = "Acceso no autorizado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<CandidateResponseDTO> getCandidateById(@PathVariable Long id) {
        return ResponseEntity.ok(candidateService.getCandidateById(id));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "eliminar candidatos", description = "Hace una eliminacion Logica del Candidato.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Candidato eliminado con éxito"),
            @ApiResponse(responseCode = "404", description = "Candidato No Existe"),
            @ApiResponse(responseCode = "401", description = "Acceso no autorizado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<CandidateResponseDTO> deleteCandidateById(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity.ok().build();
    }
}
