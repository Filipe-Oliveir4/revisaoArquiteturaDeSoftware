package com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.dto.converter;

import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.dto.RecursoDto;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.RecursoEntity;

import java.util.ArrayList;
import java.util.List;

public class RecursoConverter {
    public static RecursoEntity toEntity(RecursoDto recursoDto) {
        if (recursoDto == null) {
            return null;
        }
        return RecursoEntity.builder()
                .idRecurso(recursoDto.getIdRecurso())
                .nome(recursoDto.getNome())
                .build();
    }
    public static RecursoDto toDto(RecursoEntity recursoEntity) {
        if (recursoEntity == null) {
            return null;
        }
        return RecursoDto.builder()
                .idRecurso(recursoEntity.getIdRecurso())
                .nome(recursoEntity.getNome())
                .build();
    }
    public static List<RecursoEntity> toListEntity(List<RecursoDto> recursoDtos) {
        if (recursoDtos == null) {
            return null;
        }
        List<RecursoEntity> retorno = new ArrayList<>();
        for (RecursoDto recursoDto : recursoDtos) {
            retorno.add(toEntity(recursoDto));
        }
        return retorno;
    }
    public static List<RecursoDto> toListDto(List<RecursoEntity> recursoEntities) {
        if (recursoEntities == null) {
            return null;
        }
        List<RecursoDto> retorno = new ArrayList<>();
        for (RecursoEntity recursoEntity : recursoEntities) {
            retorno.add(toDto(recursoEntity));
        }
        return retorno;
    }
}
