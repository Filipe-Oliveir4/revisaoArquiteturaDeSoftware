package com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.controller;

import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.dto.UserDto;
import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.dto.UserDtoConverter;
import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.entity.UserEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/autenticacao")
public class AutenticacaoController {

    @Autowired
    UserService userService;
    @PostMapping("/cadastrarUsuario")
    public ResponseEntity cadastrarUsuario(@RequestBody UserDto userDto){
        UserEntity userEntity = UserDtoConverter.toEntity(userDto);
        try {
            userService.cadastrarUsuario(userEntity);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
