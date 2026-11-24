package com.monex.usuarios.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 72)
    @Size (min = 3, max = 72, message = "O Nome deve ter entre 3 a 72 caracteres")
    @Pattern(regexp = "^\\p{L}+([ '-]\\p{L}+)*$", message = "Digite apenas o nome")
    @NotBlank (message = "Digite um nome")
    private String name;


    @Email(message = "Digite um email valido")
    @Column (nullable = false, length = 72,unique = true)
    @NotBlank (message = "Digite um email")
    @Size (min = 3, max = 72)
    private String email;

    @Column (nullable = false,length = 72)
    @Size (min = 6, max = 72, message = "Senha deve ser de 6 a 72 caracteres")
    @NotBlank (message = "Digite uma senha")
    private String password;

    @Column (nullable = false)
    @NotNull (message = "Digite uma idade")
    @Min(value = 18, message =  "Digite uma idade maior que 18 anos")
    @Max(value = 100, message = "Digite uma idade valida")
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