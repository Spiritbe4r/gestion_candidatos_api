package com.cardenascode.gestion_candidatos.infrastructure.mappers;

import com.cardenascode.gestion_candidatos.domain.model.User;
import com.cardenascode.gestion_candidatos.infrastructure.persistence.JpaUserEntity;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.RegisterRequestDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.UserResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDomain(JpaUserEntity entity);

    JpaUserEntity toEntity(User domain);

    User toDomain(RegisterRequestDTO request);

    UserResponseDTO toResponse(User userDomain);

}
