package com.cardenascode.gestion_candidatos.domain.persistence_ports;

import com.cardenascode.gestion_candidatos.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepositoryPort {
    User save(User candidate);

    Optional<User> findByEmail(String email);

}