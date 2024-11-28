package com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.dto.converter;

import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.dto.UserDtoConverter;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.dto.converter.EspacoFisicoConverter;
import com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.dto.SolicitacaoDto;
import com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.entity.SolicitacaoEntity;

public class SolicitacaoConverter {

    public static SolicitacaoDto toDto(SolicitacaoEntity solicitacao) {
        return SolicitacaoDto.builder()
                .idSolicitacoes(solicitacao.getIdSolicitacoes())
                .userDto(UserDtoConverter.toDto(solicitacao.getUser()))
                .espacoFisicoDto(EspacoFisicoConverter.toDto(solicitacao.getEspacoFisicoEntity()))
                .inicio(solicitacao.getInicio())
                .fim(solicitacao.getFim())
                .status(solicitacao.getStatus())
                .necessidadesEspecificas(solicitacao.getNecessidadesEspecificas())
                .canceladoEm(solicitacao.getCanceladoEm())
                .build();
    }

    public static SolicitacaoEntity toEntity(SolicitacaoDto solicitacao) {
        return SolicitacaoEntity.builder()
                .idSolicitacoes(solicitacao.getIdSolicitacoes())
                .user(UserDtoConverter.toEntity(solicitacao.getUserDto()))
                .espacoFisicoEntity(EspacoFisicoConverter.toEntity(solicitacao.getEspacoFisicoDto()))
                .inicio(solicitacao.getInicio())
                .fim(solicitacao.getFim())
                .status(solicitacao.getStatus())
                .necessidadesEspecificas(solicitacao.getNecessidadesEspecificas())
                .canceladoEm(solicitacao.getCanceladoEm())
                .build();
    }
}
