package com.monex.usuarios.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name = "usuario")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false,length =72)
    @Size (min = 3, max = 72)
    @NotBlank(message = "Nome é Obrigatorio")
    @Pattern(regexp = "^\\p{L}+([ '-]\\p{L}+)*$",message = "Digite um nome valido")
    private String name;


    @Email (message = "Digite um email valido")
    @NotBlank
    @Column (nullable = false,length = 72,unique = true)
    @Size (min = 3, max = 72)
    private String email;

    @Column(nullable = false)
    @NotNull
    @Min(value = 18, message = "Minimo de 18 anos")
    @Max(value = 100, message = "Maximo de 100 anos")
    private Integer age;

    @NotBlank
    @Column(nullable = false,length = 72)
    @Size(min = 8, max = 72)
    private String password;

    protected Usuario (){}

    public Usuario(String name, String email, Integer age, String password) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}