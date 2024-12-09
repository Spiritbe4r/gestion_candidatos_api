package com.cardenascode.gestion_candidatos.domain.persistence_ports;

import com.cardenascode.gestion_candidatos.domain.model.Candidate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CandidateRepositoryPort {
    Candidate save(Candidate candidate);

    List<Candidate> findAll();

    Optional<Candidate> findById(Long id);

    Optional<Candidate> findByEmail(String email);

    Candidate update(Long id, Candidate classification);

    void deleteById(Long id);
}