package com.cardenascode.gestion_candidatos.application.service;

import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.CandidateRequestDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.CandidateResponseDTO;

import java.util.List;

public interface CandidateService {
    CandidateResponseDTO createCandidate(CandidateRequestDTO candidate);
    List<CandidateResponseDTO> getAllCandidates();
    CandidateResponseDTO getCandidateById(Long id);
    CandidateResponseDTO updateCandidate(Long id, CandidateRequestDTO candidateRequestDTO);

    void deleteCandidate(Long id);
}
