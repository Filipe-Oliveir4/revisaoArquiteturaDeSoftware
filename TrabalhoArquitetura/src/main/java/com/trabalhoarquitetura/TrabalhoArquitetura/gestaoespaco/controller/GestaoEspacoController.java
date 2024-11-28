package com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.controller;


import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.dto.EspacoFisicoDto;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.dto.CadastrarRecursoDto;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.dto.converter.EspacoFisicoConverter;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.EspacoFisicoEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.entity.RecursoEntity;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.service.EspacoFisicoService;
import com.trabalhoarquitetura.TrabalhoArquitetura.gestaoespaco.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/gestaoespaco")
public class GestaoEspacoController {

    @Autowired
    EspacoFisicoService espacoFisicoService;

    @Autowired
    RecursoService recursoService;

    @PostMapping("/cadastrarEspaco")
    public ResponseEntity CadastrarEspaco(@RequestBody EspacoFisicoDto espaco) {
        EspacoFisicoEntity espacoFisicoEntity = EspacoFisicoConverter.toEntity(espaco);
        if(espacoFisicoEntity != null){
            espacoFisicoEntity = espacoFisicoService.cadastrarEspaco(espacoFisicoEntity);
        }
        if(espacoFisicoEntity != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(EspacoFisicoConverter.toDto(espacoFisicoEntity));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Erro ao cadastrar espaço"));
        }


    }

    @PostMapping("/editarEspaco")
    public ResponseEntity EditarEspaco(@RequestBody EspacoFisicoDto espacoFisicoDto) {
        EspacoFisicoEntity espacoFisicoEntity = null;
        if(espacoFisicoDto!=null){
            espacoFisicoEntity = espacoFisicoService.findById(espacoFisicoDto.getIdEspaco());
            espacoFisicoEntity.setNome(espacoFisicoDto.getNome());
            espacoFisicoEntity.setCapacidade(espacoFisicoDto.getCapacidade());
            espacoFisicoEntity.setLocalizacao(espacoFisicoDto.getLocalizacao());
        }
        EspacoFisicoEntity response = espacoFisicoService.editarEspaco(espacoFisicoEntity);
        return ResponseEntity.status(HttpStatus.OK).body(EspacoFisicoConverter.toDto(response));
    }

    @PostMapping("/cadastrarRecurso")
    public ResponseEntity CadastrarRecurso(@RequestBody CadastrarRecursoDto cadastrarRecursoDto) {
        try {
            EspacoFisicoEntity espacoFisicoEntity = espacoFisicoService.findById(cadastrarRecursoDto.getIdEspacoFisico());
            RecursoEntity recursoEntity = recursoService.findById(cadastrarRecursoDto.getIdRecurso());
            espacoFisicoEntity.getRecursos().add(recursoEntity);
            espacoFisicoEntity = espacoFisicoService.cadastrarRecurso(espacoFisicoEntity);
            return ResponseEntity.status(HttpStatus.OK).body(EspacoFisicoConverter.toDto(espacoFisicoEntity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", "Erro ao cadastrar recurso"));
        }
    }
}
