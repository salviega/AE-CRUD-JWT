package com.app.crud.security.servicesSecurity;

import com.app.crud.security.modelsSecurity.UsuarioModel;
import com.app.crud.security.modelsSecurity.UsuarioPrincipalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        UsuarioModel usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipalModel.build(usuario);
    }
}
