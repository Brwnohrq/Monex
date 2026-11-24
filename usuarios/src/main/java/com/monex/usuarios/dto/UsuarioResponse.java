package com.monex.usuarios.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.monex.usuarios.model.Usuario;

@JsonPropertyOrder ({"id","name","email","age"})
public class UsuarioResponse {

    private Long id;
    private String name;
    private String email;
    private Integer age;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.email = usuario.getEmail();
        this.age = usuario.getAge();
    }

    public Long getId() {
        return id;
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


}