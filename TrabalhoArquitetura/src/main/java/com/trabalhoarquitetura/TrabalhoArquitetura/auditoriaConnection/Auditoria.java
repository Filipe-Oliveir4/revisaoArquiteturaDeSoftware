package com.trabalhoarquitetura.TrabalhoArquitetura.auditoriaConnection;

import jakarta.inject.Singleton;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Singleton
public class Auditoria {

   private final RestTemplate restTemplate;

    public Auditoria(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void enviarAuditoria(String modulo, String acao, Long idObjeto){
        AuditoriaDTO auditoriaDTO = AuditoriaDTO.builder()
                .modulo(modulo)
                .acao(acao)
                .idObjeto(idObjeto)
                .build();
        restTemplate.postForObject("http://auditoria/auditoria", auditoriaDTO, void.class);
    }
}
