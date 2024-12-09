package com.cardenascode.gestion_candidatos.domain.model;

import java.math.BigDecimal;

public class Candidate {
    private Long id;
    private String name;
    private String email;
    private String gender;
    private BigDecimal salaryExpected;

    public Candidate(Long id, String name, String email, String gender, BigDecimal salaryExpected) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.salaryExpected = salaryExpected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void validateEmail() {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    public String getGender() {
        return gender;
    }

    public BigDecimal getSalaryExpected() {
        return salaryExpected;
    }
}
