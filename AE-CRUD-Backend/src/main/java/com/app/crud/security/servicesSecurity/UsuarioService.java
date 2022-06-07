package com.app.crud.security.servicesSecurity;

import com.app.crud.security.modelsSecurity.UsuarioModel;
import com.app.crud.security.repositoriesSecurity.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional //si hay varios accesos y hay una incoherencia se vuelve al estado anterior
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<UsuarioModel> getByNombreUsuario(String nombreUsuario) {
        return  usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
    public void save(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
    }
}
