package com.monex.usuarios.service;

import com.monex.usuarios.UsuariosApplication;
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

    public Optional<Usuario> cadastrar(Usuario usuario) {

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return Optional.empty();
        }
        Usuario salvo = usuarioRepository.save(usuario);
        return Optional.of(salvo);
    }


    public boolean autenticar(String email, String password) {


        Optional <Usuario> usuarioInicial = usuarioRepository.findByEmail(email);
        if (usuarioInicial.isEmpty()){
            return false;
        }
        Usuario usuarioFinal = usuarioInicial.get();

        return usuarioFinal.getPassword().equals(password);
    }
}