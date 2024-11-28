package com.auditoriaMicro.controller;

import com.auditoriaMicro.dto.AuditoriaDTO;
import com.auditoriaMicro.dto.AuditoriaDTOConverter;
import com.auditoriaMicro.service.AuditoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditoria")
public class AuditoriaController {

    private final AuditoriaService auditoriaService;

    public AuditoriaController(AuditoriaService auditoriaService) {
        this.auditoriaService = auditoriaService;
    }

    @GetMapping("/listarAuditorias")
    public ResponseEntity<List<AuditoriaDTO>> findAll() {
        return ResponseEntity.ok(AuditoriaDTOConverter.toListDTO(auditoriaService.findAll()));
    }

    @GetMapping("/listarAuditoriasPorModulo/{modulo}")
    public ResponseEntity<List<AuditoriaDTO>> findByModulo(@PathVariable String modulo) {
        return ResponseEntity.ok(AuditoriaDTOConverter.toListDTO(auditoriaService.findByModulo(modulo)));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody AuditoriaDTO auditoriaDTO) {
        auditoriaService.save(AuditoriaDTOConverter.toEntity(auditoriaDTO));
        return ResponseEntity.ok().build();
    }
}
