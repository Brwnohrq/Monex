package com.monex.usuarios.controller;

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

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

 private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity <?> cadastrar(@Valid @RequestBody Usuario usuario){
       if (!usuarioService.cadastrar(usuario)){
           return ResponseEntity.status(HttpStatus.CONFLICT).body("Email ja existente");
       }
       return ResponseEntity.status(HttpStatus.CREATED).build();
}
}