package ar.com.fluxit.candidatos.service.impl;

import ar.com.fluxit.candidatos.entity.UserEntity;
import ar.com.fluxit.candidatos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Pablo on 5/11/2019.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public JwtUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }


    public UserDetails loadUserByUsername(String name) {
        Optional<UserEntity> userEntity = repository.findByUsername(name);
        if (userEntity.isPresent()) {

            return new org.springframework.security.core.userdetails.User(userEntity.get().getUsername(), userEntity.get().getPassword(), userEntity.get().getAuthorities());
        } else {
            return null;
        }

    }


}
