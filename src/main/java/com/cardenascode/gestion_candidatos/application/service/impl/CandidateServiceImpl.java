package com.cardenascode.gestion_candidatos.application.service.impl;

import com.cardenascode.gestion_candidatos.application.service.CandidateService;

import com.cardenascode.gestion_candidatos.domain.exception.AlreadyExistsException;
import com.cardenascode.gestion_candidatos.domain.exception.CandidateNotFoundException;
import com.cardenascode.gestion_candidatos.domain.persistence_ports.CandidateRepositoryPort;
import com.cardenascode.gestion_candidatos.infrastructure.mappers.CandidateMapper;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.CandidateRequestDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.CandidateResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepositoryPort candidateRepositoryPort;
    private final CandidateMapper candidateMapper;

    public CandidateServiceImpl(CandidateRepositoryPort candidateRepositoryPort, CandidateMapper candidateMapper) {
        this.candidateRepositoryPort = candidateRepositoryPort;
        this.candidateMapper = candidateMapper;
    }

    @Override
    public CandidateResponseDTO createCandidate(CandidateRequestDTO candidate) {
        var newCandidate = candidateRepositoryPort.findByEmail(candidate.getEmail());
        if (newCandidate.isPresent()) {
            throw new AlreadyExistsException("Candidate with email: " + candidate.getEmail() + " already exists");
        }
        var candidateDomain = candidateMapper.toDomain(candidate);
        return candidateMapper.toResponse(candidateRepositoryPort.save(candidateDomain));
    }

    @Override
    public List<CandidateResponseDTO> getAllCandidates() {
        return candidateRepositoryPort.findAll().stream().map(candidateMapper::toResponse).toList();
    }

    @Override
    public CandidateResponseDTO getCandidateById(Long id) {

        return candidateRepositoryPort.findById(id)
                .map(candidateMapper::toResponse)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id:"));

    }

    @Override
    public CandidateResponseDTO updateCandidate(Long id, CandidateRequestDTO candidateRequestDTO) {
        var candidateDomain = candidateMapper.toDomain(candidateRequestDTO);
        return candidateMapper.toResponse(candidateRepositoryPort.update(id, candidateDomain));
    }

    @Override
    public void deleteCandidate(Long id) {
        candidateRepositoryPort.deleteById(id);
    }
}

