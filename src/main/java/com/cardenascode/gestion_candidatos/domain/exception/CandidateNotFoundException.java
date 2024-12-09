package com.cardenascode.gestion_candidatos.domain.exception;

public class CandidateNotFoundException extends RuntimeException{
    public CandidateNotFoundException(String message) {
        super(message);
    }
}