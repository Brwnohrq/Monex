package com.monex.usuarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;



@Entity
@Table (name = "USUARIO")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "Name is required")
    @Column(nullable = false, length = 100)
    @Size(min = 3, max = 100,message = "Name must be between 3 and 100 characters")
    @Pattern
    (
            regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ]+([ '-][A-Za-zÀ-ÖØ-öø-ÿ]+)*$",
            message = "Invalid name. Use only letters, spaces, hyphens or apostrophes"
    )
    private String name;



    @Email (message = "Enter a valid email address")
    @NotBlank (message = "Email is required")
    @Column(unique = true,nullable = false,length = 100)
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 18,message = "Minimum age to open an account is 18")
    @Max(value = 100,message = "Age exceeds the maximum allowed to open an account")
    @Column(nullable = false)
    private Integer age;


    @NotBlank (message = "Password is required")
    @Column(nullable = false,length = 72)
    @Size (min = 8, max = 72,message = "Password must be between 8 and 72 characters")
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