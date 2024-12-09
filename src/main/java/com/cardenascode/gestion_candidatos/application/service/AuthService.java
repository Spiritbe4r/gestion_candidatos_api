package com.cardenascode.gestion_candidatos.application.service;

import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.AuthResponseDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.LoginDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.RegisterRequestDTO;
import com.cardenascode.gestion_candidatos.infrastructure.rest.dto.UserResponseDTO;

public interface AuthService {

     UserResponseDTO register(RegisterRequestDTO request);

     AuthResponseDTO login(LoginDTO request) ;
}
