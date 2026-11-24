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


    public Optional<Usuario> cadastrar (Usuario usuario){

        if (usuarioRepository.existsByEmail(usuario.getEmail())){
            return Optional.empty();
        }
        usuarioRepository.save(usuario);
        return Optional.of(usuario);
    }

    public Optional <Usuario> autenticar (String email, String password){

        Optional <Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isEmpty()){
            return Optional.empty();
        }
        Usuario usuarioFinal = usuario.get();

        if (!usuarioFinal.getPassword().equals(password)){
            return Optional.empty();
        }
        return Optional.of(usuarioFinal);

    }
}