package com.cardenascode.gestion_candidatos.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<JpaUserEntity, Long> {

    Optional<JpaUserEntity> findByEmail(String email);
}
