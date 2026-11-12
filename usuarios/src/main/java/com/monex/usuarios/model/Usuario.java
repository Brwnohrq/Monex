package com.monex.usuarios.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table (name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotBlank(message = "O nome é Obrigatorio")
    @Size(min = 3, max = 100,message = "O nome pode conter de 3 a 100 caracateres")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s'-]+$", message = "O nome deve conter apenas letras e espaços")
    @Column (nullable = false, length =  100)
    private String name;

    @NotNull
    @Min(value = 18, message = "Precisa ter pelo menos 18 anos para criar a conta")
    @Max(value = 120, message = "Idade excede o limite, consulte um dos nossos atendentes")
    @Column (nullable = false)
    private Integer age;

    @Email(message = "Email invalido")
    @Column(unique = true, nullable = false,length = 100)
    @NotBlank (message = "Email é Obrigatorio")
    private String email;

    @NotBlank(message = "Senha é Obrigatorio")
    @Size (min = 8, max = 72,message = "A senha deve conter de 8 a 72 caracteres")
    @Column(nullable = false,length = 72)
    private String password;


    protected Usuario() {}

    public Usuario (String name, Integer age, String email, String password){
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
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

    public Long getId() {
        return id;
    }




}
