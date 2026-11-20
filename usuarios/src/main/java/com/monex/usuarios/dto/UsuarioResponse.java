package com.monex.usuarios.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.monex.usuarios.model.Usuario;

@JsonPropertyOrder({"id", "name", "email", "age"})
public class UsuarioResponse {

    private String name;
    private String email;
    private Integer age;
    private Long id;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.age = usuario.getAge();
        this.email = usuario.getEmail();
        this.name = usuario.getName();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }
}