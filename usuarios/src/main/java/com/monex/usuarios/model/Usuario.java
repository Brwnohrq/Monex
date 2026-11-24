package com.monex.usuarios.model;


import jakarta.persistence.*;

@Entity
@Table (name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 72)
    private String name;


    @Column (nullable = false, length = 72,unique = true)
    private String email;

    @Column (nullable = false,length = 72)
    private String password;

    @Column (nullable = false)
    private Integer age;

    public Usuario(String name, String email, String password, Integer age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    protected Usuario (){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}