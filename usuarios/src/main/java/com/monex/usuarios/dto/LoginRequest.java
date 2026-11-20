package com.monex.usuarios.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class LoginRequest {


    @Email (message = "Digite um email valido")
    @NotBlank (message = "Digite um email")
    private String email;

    @NotBlank(message = "Digite uma senha")
    private String password;


    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    protected LoginRequest (){}

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}