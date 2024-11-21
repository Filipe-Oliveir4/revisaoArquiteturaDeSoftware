package com.laboratorioMicro.laboratorioMicro.service;

import com.laboratorioMicro.laboratorioMicro.entity.Usuario;
import com.laboratorioMicro.laboratorioMicro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Criação de Usuario
    //Exclusão
    //Retorna todos os usuários
    //Retorna usuario a partir do login
    public Usuario cadastrarUsuario(Usuario usuarioRequest) throws Exception {
        Usuario usuario = this.usuarioRepository.getUsuarioPeloLogin(usuarioRequest.getLogin());
        if(usuario != null){
            throw new Exception("Usuario já criado");
        }
        if(usuarioRequest.getLogin()==null || usuarioRequest.getSenha() ==null){
            throw new Exception("Há algum campo vazio");
        }
        return this.usuarioRepository.save(usuarioRequest);
    }
    public String deletarUsuario(String login){
        Usuario usuario = this.usuarioRepository.getUsuarioPeloLogin(login);
        if(usuario!=null){
            this.usuarioRepository.delete(usuario);
            return "Usuario Deletado";
        }else{
            return "Usuario não existe";
        }
    }

    public List<Usuario> getTodosUsarios() {
        return this.usuarioRepository.findAll();
    }
    public Usuario getUsuario(String login){
        Usuario usuario = this.usuarioRepository.getUsuarioPeloLogin(login);
        if(usuario!=null){
            return usuario;
        }else{
            return null;
        }
    }
}
