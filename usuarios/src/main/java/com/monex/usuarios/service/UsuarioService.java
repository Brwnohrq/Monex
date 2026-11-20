package com.monex.usuarios.service;

import com.monex.usuarios.model.Usuario;
import com.monex.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean cadastrar (Usuario usuario) {

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return false;
        }
        usuarioRepository.save(usuario);
        return true;
    }

    public boolean autenticar (String email, String password){

        Optional <Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isEmpty()){
            return false;
        }
        Usuario usuarioBanco = usuario.get();

        return usuarioBanco.getPassword().equals(password);
        }


    }


