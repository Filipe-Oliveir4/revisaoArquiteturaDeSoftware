package com.auditoriaMicro.dto;

import com.auditoriaMicro.entity.Auditoria;

import java.util.ArrayList;
import java.util.List;

public class AuditoriaDTOConverter {

    public static AuditoriaDTO toDTO(Auditoria auditoria) {
        if (auditoria == null) {
            return null;
        }
        return  AuditoriaDTO.builder()
                .id(auditoria.getId())
                .modulo(auditoria.getModulo())
                .acao(auditoria.getAcao())
                .idObjeto(auditoria.getIdObjeto())
                .dataHora(auditoria.getDataHora())
                .build();
    }

    public static Auditoria toEntity(AuditoriaDTO auditoriaDTO) {
        if(auditoriaDTO == null) {
            return null;
        }
        return Auditoria.builder()
                .modulo(auditoriaDTO.getModulo())
                .acao(auditoriaDTO.getAcao())
                .idObjeto(auditoriaDTO.getIdObjeto())
                .build();
    }

    public static List<AuditoriaDTO> toListDTO(List<Auditoria> auditorias) {
        if (auditorias == null) {
            return null;
        }
        List<AuditoriaDTO> auditoriaDTOList = new ArrayList<>();
        for (Auditoria auditoria : auditorias) {
            auditoriaDTOList.add(toDTO(auditoria));
        }
        return auditoriaDTOList;
    }

}
