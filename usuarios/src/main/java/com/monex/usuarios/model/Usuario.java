package com.monex.usuarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;



@Entity
@Table (name = "USUARIO")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "Nome é Obrigatorio")
    @Column(nullable = false, length = 100)
    @Size(min = 3, max = 100,message = "O Nome tem que ter entre 3 a 100 caracteres")
    @Pattern
    (
            regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ]+([ '-][A-Za-zÀ-ÖØ-öø-ÿ]+)*$",
            message = "Nome inválido. Use apenas letras, espaços, hífens ou apóstrofos."
    )
    private String name;



    @Email (message = "Digite um email valido")
    @NotBlank (message = "Email Obrigatorio")
    @Column(unique = true,nullable = false,length = 100)
    private String email;

    @NotNull(message = "Digite uma idade valida")
    @Min(value = 18,message = "idade minima pra abrir a conta é 18 anos")
    @Max(value = 100,message = "idade excedida para abertura de conta")
    @Column(nullable = false)
    private Integer age;


    @NotBlank (message = "Digite uma senha valida")
    @Column(nullable = false,length = 72)
    @Size (min = 8, max = 72,message = "Senha deve conter de 8 a 72 caracteres")
    private String password;

    protected Usuario (){}

    public Usuario (String name, String email, Integer age, String password){
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