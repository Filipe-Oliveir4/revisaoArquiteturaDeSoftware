package com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.service;

import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.entity.RoleEnum;
import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.entity.UserEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public UserEntity cadastrarUsuario(UserEntity user) throws Exception {
        //Verifica se o usuário já está cadastrado
        if(userRepository.findByUsername(user.getUsername()) != null){
            throw new Exception("Usuário já cadastrado");
        }
        //Verifica se os campos estão preenchidos
        if(user.getUsername()==null || user.getPassword()==null || user.getNome()==null || user.getRole()==null){
            throw new Exception("Campos obrigatórios não preenchidos");
        }
        //Verifica se a role é válida
        if (!(user.getRole().equals(RoleEnum.ADMIN.name()) || user.getRole().equals(RoleEnum.GESTOR.name()) || user.getRole().equals(RoleEnum.PROFESSOR.name()))){
            throw new Exception("Role inválida");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return user;
    }

    public UserEntity findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserEntity save(UserEntity user){
        String senha = user.getPassword();
        user.setPassword(passwordEncoder.encode(senha));
        return userRepository.save(user);
    }
}
