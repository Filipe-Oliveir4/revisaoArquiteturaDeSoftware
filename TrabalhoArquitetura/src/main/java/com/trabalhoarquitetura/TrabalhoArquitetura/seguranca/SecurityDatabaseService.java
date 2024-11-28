package com.trabalhoarquitetura.TrabalhoArquitetura.seguranca;

import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.entity.RoleEnum;
import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.entity.UserEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SecurityDatabaseService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        List.of(RoleEnum.ADMIN,RoleEnum.GESTOR,RoleEnum.PROFESSOR).forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        });
        return new org.springframework.security.core.userdetails.User(userEntity.getUsername(),
                userEntity.getPassword(),
                authorities);
    }

}
