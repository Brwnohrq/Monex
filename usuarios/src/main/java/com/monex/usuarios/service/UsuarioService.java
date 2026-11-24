package com.monex.usuarios.service;


import com.monex.usuarios.dto.CadastroRequest;
import com.monex.usuarios.model.Usuario;
import com.monex.usuarios.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Optional<Usuario> cadastrar (CadastroRequest request) {

        if (usuarioRepository.existsByEmail(request.getEmail())){
            return Optional.empty();
        }
        Usuario usuario = new Usuario(
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getAge()
        );
        usuarioRepository.save(usuario);
        return Optional.of(usuario);

    }

    public Optional <Usuario> autenticar (String email, String password){

        Optional <Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isEmpty()){
            return Optional.empty();
        }
        Usuario usuarioFinal = usuario.get();

        if (!passwordEncoder.matches(password, usuarioFinal.getPassword())){
            return Optional.empty();
        }
        return Optional.of(usuarioFinal);
}
}