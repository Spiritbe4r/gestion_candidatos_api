package com.cardenascode.gestion_candidatos.infrastructure.config;


import com.cardenascode.gestion_candidatos.domain.model.User;
import com.cardenascode.gestion_candidatos.domain.persistence_ports.UserRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class UserBootstrapConfig {

    private final UserRepositoryPort userRepositoryPort;

    public UserBootstrapConfig(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;

    }

    @Bean
    public ApplicationRunner createDefaultUser() {
        return args -> {
            String username = "admin6";
            String email = "admin@gmail.com";
            String password = "1234asdf";

            if (this.userRepositoryPort.findByEmail(email).isEmpty()) {
                User adminUser = new User(
                        email,
                        username,
                        true,
                        password
                );
                userRepositoryPort.save(adminUser);
                log.info("Default admin user created: {}", username);
            } else {
                log.info("Admin user already exists: {}", username);
            }
        };
    }
}
