package com.cardenascode.gestion_candidatos.infrastructure.persistence;

import com.cardenascode.gestion_candidatos.domain.model.Candidate;
import com.cardenascode.gestion_candidatos.domain.persistence_ports.CandidateRepositoryPort;

import com.cardenascode.gestion_candidatos.infrastructure.mappers.CandidateMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaCandidateRepository implements CandidateRepositoryPort {
    private final CandidateRepository springDataCandidateRepository;
    private final CandidateMapper mapper;

    public JpaCandidateRepository(CandidateRepository springDataCandidateRepository, CandidateMapper mapper) {
        this.springDataCandidateRepository = springDataCandidateRepository;
        this.mapper = mapper;
    }

    public Candidate save(Candidate candidate) {

        JpaCandidateEntity entity = mapper.toEntity(candidate);
        return mapper.toDomain(springDataCandidateRepository.save(entity));
    }

    public List<Candidate> findAll() {
        return springDataCandidateRepository.findAllByActiveTrue()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    public Optional<Candidate> findById(Long id) {
        return springDataCandidateRepository.findByIdAndActiveTrue(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Candidate> findByEmail(String email) {
        return springDataCandidateRepository.findByEmailAndActiveTrue(email).map(mapper::toDomain);
    }

    @Override
    public Candidate update(Long id, Candidate candidate) {
        var candidateEntity = springDataCandidateRepository.findByIdAndActiveTrue(id).orElseThrow();
        candidateEntity.setName(candidate.getName());
        candidateEntity.setEmail(candidate.getEmail());
        candidateEntity.setSalaryExpected(candidate.getSalaryExpected());
        candidateEntity.setGender(candidate.getGender());
        return mapper.toDomain(springDataCandidateRepository.save(candidateEntity));
    }

    @Override
    public void deleteById(Long id) {
        var candidateEntity = springDataCandidateRepository.findByIdAndActiveTrue(id).orElseThrow();
        candidateEntity.setActive(false);
        springDataCandidateRepository.save(candidateEntity);
    }
}
