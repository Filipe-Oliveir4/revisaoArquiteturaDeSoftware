package com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.controller;

import com.trabalhoarquitetura.TrabalhoArquitetura.autenticacao.service.UserService;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.service.EspacoFisicoService;
import com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.dto.SolicitacaoDto;
import com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.dto.converter.SolicitacaoConverter;
import com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.entity.SolicitacaoEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.solicitacoes.service.SolicitacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping("/api/solicitacoes")
public class SolicitacoesController {

    @Autowired
    SolicitacoesService solicitacoesService;

    @Autowired
    UserService userService;

    @Autowired
    EspacoFisicoService espacoFisicoService;

    @PostMapping("/cadastrarSolicitacao")
    public ResponseEntity CadastrarSolicitacao(@RequestBody SolicitacaoDto solicitacao) {
        SolicitacaoEntity solicitacaoEntity = SolicitacaoConverter.toEntity(solicitacao);
        try {
            solicitacaoEntity = solicitacoesService.cadastrarSolicitacao(solicitacaoEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(SolicitacaoConverter.toDto(solicitacaoEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    @PostMapping("/cancelarSolicitacao/{id}")
    public ResponseEntity cancelarSolicitacao(@PathVariable Long id) {
        try {
            SolicitacaoEntity solicitacaoEntity = solicitacoesService.cancelarSolicitacao(id);
            return ResponseEntity.status(HttpStatus.OK).body(SolicitacaoConverter.toDto(solicitacaoEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/listarSolicitacoes")
    public ResponseEntity listarSolicitacoes() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(solicitacoesService.listarSolicitacoes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }


    @PostMapping("/editarSolicitacao")
    public ResponseEntity editarSolicitacao(@RequestBody SolicitacaoDto solicitacao) {
        SolicitacaoEntity solicitacaoEntity = SolicitacaoConverter.toEntity(solicitacao);
        try {
            solicitacaoEntity.setEditadoEm(LocalDateTime.now());
            solicitacaoEntity = solicitacoesService.editarSolicitacao(solicitacaoEntity);
            return ResponseEntity.status(HttpStatus.OK).body(SolicitacaoConverter.toDto(solicitacaoEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/solicitacoesPendentes")
    public ResponseEntity solicitacoesPendentes() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(solicitacoesService.solicitacoesPendentes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/solicitacoesAprovadas")
    public ResponseEntity solicitacoesAprovadas() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(solicitacoesService.solicitacoesAprovadas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/solicitacoesRejeitadas")
    public ResponseEntity solicitacoesRejeitadas() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(solicitacoesService.solicitacoesRejeitadas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }

    @PostMapping("/resolverSolicitacao")
    public ResponseEntity resolverSolicitacao(@RequestBody SolicitacaoDto solicitacao, @RequestBody String observacao) {
        try {
            SolicitacaoEntity solicitacaoEntity = solicitacoesService.findById(solicitacao.getIdSolicitacoes());
            if (solicitacaoEntity.getStatus() != null) {
                throw new Exception("Solicitação já resolvida");
            }
            solicitacaoEntity.setStatus(solicitacao.getStatus());
            solicitacaoEntity = solicitacoesService.resolverSolicitacao(solicitacaoEntity, observacao);
            return ResponseEntity.status(HttpStatus.OK).body(SolicitacaoConverter.toDto(solicitacaoEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }
}
