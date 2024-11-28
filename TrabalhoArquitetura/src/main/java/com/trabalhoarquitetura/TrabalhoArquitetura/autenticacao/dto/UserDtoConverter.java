package com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.dto;

import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.entity.UserEntity;

public class UserDtoConverter {
    public static UserDto toDto(UserEntity user) {
        return UserDto.builder()
                .idUsuario(user.getIdUsuario())
                .nome(user.getNome())
                .username(user.getUsername())
                .build();
    }

    public static UserEntity toEntity(UserDto user) {
        return UserEntity.builder()
                .idUsuario(user.getIdUsuario())
                .nome(user.getNome())
                .username(user.getUsername())
                .build();
    }
}
