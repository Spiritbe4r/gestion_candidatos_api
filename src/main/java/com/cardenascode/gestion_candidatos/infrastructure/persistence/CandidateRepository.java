package com.cardenascode.gestion_candidatos.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends JpaRepository<JpaCandidateEntity, Long> {

    List<JpaCandidateEntity> findAllByActiveTrue();

    Optional<JpaCandidateEntity> findByIdAndActiveTrue(Long id);

    Optional<JpaCandidateEntity> findByEmailAndActiveTrue(String email);
}
