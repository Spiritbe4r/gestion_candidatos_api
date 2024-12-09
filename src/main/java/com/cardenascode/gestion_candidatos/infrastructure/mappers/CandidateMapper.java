package com.cardenascode.gestion_candidatos.infrastructure.mappers;

import com.cardenascode.gestion_candidatos.domain.model.Candidate;
import com.cardenascode.gestion_candidatos.infrastructure.persistence.JpaCandidateEntity;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.CandidateRequestDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.CandidateResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateMapper {


    Candidate toDomain(JpaCandidateEntity entity);

    JpaCandidateEntity toEntity(Candidate domain);


    Candidate toDomain(CandidateRequestDTO request);

    CandidateResponseDTO toResponse(Candidate domain);
}
