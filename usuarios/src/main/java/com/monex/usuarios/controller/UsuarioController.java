package com.monex.usuarios.controller;


import com.monex.usuarios.model.Usuario;
import com.monex.usuarios.repository.UsuarioRepository;
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

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity <?>  cadastrar (@Valid @RequestBody Usuario usuario){
        if (usuarioRepository.existsByEmail(usuario.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email existente");
        }
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}