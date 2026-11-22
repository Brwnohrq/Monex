package com.monex.usuarios.controller;

import com.monex.usuarios.dto.LoginRequest;
import com.monex.usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping ("/auth")
@RestController
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping ("/login")
    public ResponseEntity <?> autenticar (@Valid @RequestBody LoginRequest request){

       if (!usuarioService.autenticar(request.getEmail(),request.getPassword())){
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario ou senha invalidos");
       }
       return ResponseEntity.ok("Autenticado");
    }
}