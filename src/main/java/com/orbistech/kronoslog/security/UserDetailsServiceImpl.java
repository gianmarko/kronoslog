package com.orbistech.kronoslog.security;

import com.orbistech.kronoslog.model.Credencial;
import com.orbistech.kronoslog.repository.CredencialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CredencialRepository credencialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Credencial> optionalCredenciales = credencialRepository.findByCodigoEmpleado(username);
        if (!optionalCredenciales.isPresent()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        Credencial credencial = optionalCredenciales.get();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + credencial.getRol().getNombreRol().toUpperCase());
        return new User(
                credencial.getCodigoEmpleado(),
                credencial.getContrasenia(),
                Collections.singletonList(authority)
        );
    }
}
