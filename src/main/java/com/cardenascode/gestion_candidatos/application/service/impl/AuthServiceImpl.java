package com.cardenascode.gestion_candidatos.application.service.impl;

import com.cardenascode.gestion_candidatos.application.service.AuthService;
import com.cardenascode.gestion_candidatos.domain.exception.AlreadyExistsException;
import com.cardenascode.gestion_candidatos.domain.model.User;
import com.cardenascode.gestion_candidatos.infrastructure.mappers.UserMapper;
import com.cardenascode.gestion_candidatos.infrastructure.persistence.JpaUserRepository;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.AuthResponseDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.LoginDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.RegisterRequestDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.UserResponseDTO;
import com.cardenascode.gestion_candidatos.infrastructure.security.JwtUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(JpaUserRepository jpaUserRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserResponseDTO register(@Valid @RequestBody RegisterRequestDTO request) {
        var user = jpaUserRepository.findByEmail(request.email());
        if (user.isPresent()) {
            throw new AlreadyExistsException("User already exists");
        }

        var userEntity = jpaUserRepository.save(userMapper.toDomain(request));
        log.info("User registered: {}", userEntity);
        return userMapper.toResponse(userEntity);
    }

    @Override
    public AuthResponseDTO login(@Valid @RequestBody LoginDTO request) {
        User user = jpaUserRepository.findByEmail(request.email())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        return new AuthResponseDTO(jwtUtil.generateToken(user.getEmail()));
    }
}
