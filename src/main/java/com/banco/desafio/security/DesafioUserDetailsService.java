package com.banco.desafio.security;

import com.banco.desafio.entities.UserEntity;
import com.banco.desafio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DesafioUserDetailsService implements UserDetailsService {
    @Autowired
    private final UserRepository repository;

    //public DesafioUserDetailsService(UserRepository repository) {
    //    this.repository = repository;
    //}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username).get(); // .orElseThrow

        if(user == null) {
            throw new EntityNotFoundException("Usuario no encontrado");
        }

        return new DesafioUserDetails(user);
    }
}
