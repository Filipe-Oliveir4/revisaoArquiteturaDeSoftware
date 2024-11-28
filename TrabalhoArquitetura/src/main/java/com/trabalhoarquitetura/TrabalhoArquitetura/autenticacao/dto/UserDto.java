package com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long idUsuario;
    private String nome;
    private String username;
}
