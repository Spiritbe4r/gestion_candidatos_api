package com.cardenascode.gestion_candidatos.infrastructure.persistence;

import com.cardenascode.gestion_candidatos.domain.model.User;
import com.cardenascode.gestion_candidatos.domain.persistence_ports.UserRepositoryPort;
import com.cardenascode.gestion_candidatos.infrastructure.mappers.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepository implements UserRepositoryPort{
    private final UserRepository springDataCandidateRepository;

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public JpaUserRepository(UserRepository springDataCandidateRepository, UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.springDataCandidateRepository = springDataCandidateRepository;

        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User save(User candidate) {
        String passwordEncoded = passwordEncoder.encode(candidate.getPassword());
        var userEntity = userMapper.toEntity(candidate);
        userEntity.setActive(true);
        userEntity.setPassword(passwordEncoded);
        var userEntitySaved= userRepository.save(userEntity);

        return userMapper.toDomain(userEntitySaved);
    }

    public Optional<User> findByEmail(String email) {
        return springDataCandidateRepository.findByEmail(email).map(userMapper::toDomain);
    }

}
