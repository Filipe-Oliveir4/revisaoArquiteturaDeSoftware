package com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.dto;

import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.dto.UserDto;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.dto.EspacoFisicoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoDto {
    private Long idSolicitacoes;
    private UserDto userDto;
    private EspacoFisicoDto espacoFisicoDto;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Boolean status;
    private String necessidadesEspecificas;
    private LocalDateTime canceladoEm;
}
