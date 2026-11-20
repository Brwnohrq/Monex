package com.monex.usuarios.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name = "usuario")
public class Usuario {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Digite um nome")
    @Column (nullable = false,length = 72)
    @Pattern(regexp = "^\\p{L}+([ '-]\\p{L}+)*$", message = "Nome inválido")
    @Size (min = 3, max = 72)
    private String name;


    @Size (min = 8, max = 72,message = "Senha deve conter de 8 a 72 caracteres")
    @Column(nullable = false,length = 72)
    @NotBlank(message = "Digite uma senha")
    private String password;

    @Email (message =  "Digite um email valido")
    @NotBlank(message = "Digite um email")
    @Column (nullable = false,length = 72,unique = true)
    @Size (min = 4, max = 72)
    private String email;

    @Min(value = 18,message = "Idade minima 18")
    @Max(value = 100, message = "Idade maxima 100")
    @NotNull
    private Integer age;

    public Usuario(String name, String password, String email, Integer age) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    protected Usuario (){}

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
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