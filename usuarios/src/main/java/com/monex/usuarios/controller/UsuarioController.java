package com.monex.usuarios.controller;

import com.monex.usuarios.dto.CadastroRequest;
import com.monex.usuarios.dto.UsuarioResponse;
import com.monex.usuarios.model.Usuario;
import com.monex.usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping ("/usuarios")
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity <?> cadastrar (@Valid @RequestBody CadastroRequest request){

    Optional <Usuario> usuarioInicial = usuarioService.cadastrar(request);

    if (usuarioInicial.isEmpty()){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Email ja em uso");
    }
    Usuario usuarioFinal = usuarioInicial.get();

    return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioResponse(usuarioFinal));
    }

}