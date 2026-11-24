package com.monex.usuarios.dto;


import jakarta.validation.constraints.*;


public class CadastroRequest {


    @Size (min = 3, max = 72)
    @NotBlank (message =  "Digite um nome")
    @Pattern(regexp = "^\\p{L}+([ '-]\\p{L}+)*$", message = "Digite apenas o nome")
    private String name;

    @Email (message = "Digite um email valido")
    @NotBlank (message = "Digite um email")
    @Size (min = 3, max = 72, message = "Deve ter entre 3 a 72 caracteres")
    private String email;

    @NotNull (message = "Digite uma idade")
    @Min(value = 18, message = "Idade minima 18 anos")
    @Max(value = 100, message = "Idade maxima 100 anos")
    private Integer age;

    @NotBlank(message = "Digite uma senha")
    @Size (min = 6, max = 72, message = "Deve ter entre 3 a 72 caracteres")
    private String password;

    public CadastroRequest(String name, String email, Integer age, String password) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    protected CadastroRequest (){}

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


}