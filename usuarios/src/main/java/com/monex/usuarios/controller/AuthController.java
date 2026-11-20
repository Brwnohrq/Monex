package com.monex.usuarios.controller;

import com.monex.usuarios.dto.LoginRequest;
import com.monex.usuarios.model.Usuario;
import com.monex.usuarios.repository.UsuarioRepository;
import com.monex.usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

 private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping ("/login")
    public ResponseEntity <?> login (@Valid @RequestBody LoginRequest loginRequest){

       if (!usuarioService.autenticar(loginRequest.getEmail(), loginRequest.getPassword())){
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha invalido");
       }
       return ResponseEntity.ok("Login completo");

    }

}
