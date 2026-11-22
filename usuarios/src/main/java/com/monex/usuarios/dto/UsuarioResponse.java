package com.monex.usuarios.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.monex.usuarios.model.Usuario;

@JsonPropertyOrder({"id","name", "age", "email"})
public class UsuarioResponse {

    private String email;
    private String name;
    private Long id;
    private Integer age;


    public UsuarioResponse(Usuario usuario) {
        this.email = usuario.getEmail();
        this.name = usuario.getName();
        this.id = usuario.getId();
        this.age = usuario.getAge();
    }


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

}