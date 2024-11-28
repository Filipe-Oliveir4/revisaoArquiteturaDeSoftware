package com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.dto.converter;

import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.dto.EspacoFisicoDto;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.EspacoFisicoEntity;

import java.util.ArrayList;
import java.util.List;


public class EspacoFisicoConverter {

    public static EspacoFisicoEntity toEntity(EspacoFisicoDto espacoFisicoDto) {
        if(espacoFisicoDto == null){
            return null;
        }
        return EspacoFisicoEntity.builder()
                .idEspaco(espacoFisicoDto.getIdEspaco())
                .capacidade(espacoFisicoDto.getCapacidade())
                .nome(espacoFisicoDto.getNome())
                .localizacao(espacoFisicoDto.getLocalizacao()).build();

    }
    public static EspacoFisicoDto toDto(EspacoFisicoEntity espacoFisicoEntity){
        if(espacoFisicoEntity == null){
            return null;
        }
        return EspacoFisicoDto.builder()
                .idEspaco(espacoFisicoEntity.getIdEspaco())
                .capacidade(espacoFisicoEntity.getCapacidade())
                .nome(espacoFisicoEntity.getNome())
                .localizacao(espacoFisicoEntity.getLocalizacao())
                .recursos(RecursoConverter.toListDto(espacoFisicoEntity.getRecursos()))
                .build();
    }
    public static List<EspacoFisicoDto> toListDto(List<EspacoFisicoEntity> listaEntity){
        if(listaEntity == null) {
            return null;
        }
        List<EspacoFisicoDto> retorno = new ArrayList<>();
        for (EspacoFisicoEntity espacoFisico:listaEntity){
            retorno.add(toDto(espacoFisico));
        }
        return retorno;
    }

    public  static List<EspacoFisicoEntity> toListEntity(List<EspacoFisicoDto> listaDto){
        if(listaDto == null) {
            return null;
        }
        List<EspacoFisicoEntity> retorno = new ArrayList<>();
        for(EspacoFisicoDto espacoFisicoDto:listaDto){
            retorno.add(toEntity(espacoFisicoDto));
        }
        return retorno;
    }
}
