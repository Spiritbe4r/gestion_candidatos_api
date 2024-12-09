package com.cardenascode.gestion_candidatos.domain.model;

import lombok.ToString;

@ToString
public class User {
    private final String email;
    private final String password;
    private final Boolean active;
    private final String name;

    public User(String email, String name, Boolean active, String password) {
        this.email = email;
        this.name = name;
        this.active = active;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return active;
    }

    public String getPassword() {
        return password;
    }

}
