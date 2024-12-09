package com.cardenascode.gestion_candidatos.application.service;

import com.cardenascode.gestion_candidatos.application.service.impl.CandidateServiceImpl;
import com.cardenascode.gestion_candidatos.domain.model.Candidate;
import com.cardenascode.gestion_candidatos.domain.persistence_ports.CandidateRepositoryPort;
import com.cardenascode.gestion_candidatos.infrastructure.mappers.CandidateMapper;
import com.cardenascode.gestion_candidatos.infrastructure.persistence.JpaCandidateEntity;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.CandidateRequestDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.CandidateResponseDTO;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class CandidateServiceTest {

    @Mock
    private CandidateRepositoryPort candidateRepository;

    @InjectMocks
    private CandidateService candidateService;

    @Mock
    private CandidateMapper candidateMapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void testCreateCandidate() {

        CandidateRequestDTO requestDTO = new CandidateRequestDTO("John Doe", "gato@gmail.com", "Masculino", new BigDecimal("100000"));


        Candidate candidateDomain = new Candidate(null, "John Doe", "gato@gmail.com", "Masculino", new BigDecimal("100000"));
        JpaCandidateEntity candidateEntity = new JpaCandidateEntity(null, "John Doe", "gato@gmail.com", "Masculino", new BigDecimal("100000"), true);
        Candidate savedDomain = new Candidate(1L, "John Doe", "gato@gmail.com", "Masculino", new BigDecimal("50000"));
        CandidateResponseDTO responseDTO = new CandidateResponseDTO(1L, "John Doe", "gato@gmail.com", "Masculino", new BigDecimal("50000"));

        when(candidateMapper.toDomain(requestDTO)).thenReturn(candidateDomain);
        when(candidateMapper.toEntity(candidateDomain)).thenReturn(candidateEntity);
        when(candidateRepository.save(candidateDomain)).thenReturn(savedDomain);
        when(candidateMapper.toResponse(savedDomain)).thenReturn(responseDTO);



        CandidateResponseDTO result = candidateService.createCandidate(requestDTO);

        assertNotNull(result);
        assertEquals(responseDTO.id(), result.id());
        assertEquals(responseDTO.name(), result.name());

        verify(candidateRepository, times(1)).save(candidateDomain);

    }

    @Test
    void testGetAllCandidates() {

        Candidate candidateDomain = getCandidateDomain();
        CandidateResponseDTO responseDTO = getCandidateResponseDTO();

        when(candidateRepository.findAll()).thenReturn(List.of(candidateDomain));
        when(candidateMapper.toResponse(candidateDomain)).thenReturn(responseDTO);

        List<CandidateResponseDTO> result = candidateService.getAllCandidates();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(candidateDomain.getName(), result.get(0).name());

        verify(candidateRepository, times(1)).findAll();
    }

    private static CandidateResponseDTO getCandidateResponseDTO() {
        CandidateResponseDTO responseDTO = new CandidateResponseDTO(1L, "John Doe", "gato@gmail.com", "Masculino", new BigDecimal("100000"));
        return responseDTO;
    }

    private static Candidate getCandidateDomain() {
        Candidate candidateDomain = new Candidate(1L, "John Doe", "gato@gmail.com", "Masculino", new BigDecimal("100000"));
        return candidateDomain;
    }

    @Test
    void testFindCandidateById() {

        Candidate candidateDomain = getCandidateDomain();
        CandidateResponseDTO responseDTO = getCandidateResponseDTO();

        when(candidateRepository.findById(1L)).thenReturn(Optional.of(candidateDomain));
        when(candidateMapper.toResponse(candidateDomain)).thenReturn(responseDTO);

        CandidateResponseDTO result = candidateService.getCandidateById(1L);

        assertNotNull(result);
        assertEquals(candidateDomain.getId(), result.id());
        assertEquals(candidateDomain.getName(), result.name());

        verify(candidateRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteCandidate() {
        doNothing().when(candidateRepository).deleteById(1L);

        candidateService.deleteCandidate(1L);

        verify(candidateRepository, times(1)).deleteById(1L);
    }
}
