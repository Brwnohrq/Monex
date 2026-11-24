package com.monex.usuarios.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank (message = "Digite um email")
    @Email (message = "Digite um email valido")
    private String email;

    @NotBlank (message = "Digite uma senha")
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    protected LoginRequest (){}

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}