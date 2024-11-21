package com.laboratorioMicro.laboratorioMicro.controller;

import com.laboratorioMicro.laboratorioMicro.entity.Usuario;
import com.laboratorioMicro.laboratorioMicro.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario){
        try {
            return ResponseEntity.ok(this.usuarioService.cadastrarUsuario(usuario));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{login}")
    public String deletarUsuario(@PathVariable("login") String login){
        return this.usuarioService.deletarUsuario(login);
    }

    @GetMapping
    public List<Usuario> getTodosUsuarios(){
        return this.usuarioService.getTodosUsarios();
    }
    @GetMapping("/{login}")
    public Usuario getUmUsuario(@PathVariable("login") String login){
        return this.usuarioService.getUsuario(login);
    }
}
