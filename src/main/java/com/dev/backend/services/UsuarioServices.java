package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entities.Usuario;
import com.dev.backend.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UsuarioServices {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario inserir(Usuario usuario) {
        usuario.setDataCriacao(new Date());
        Usuario usuarioNovo = usuarioRepository.saveAndFlush(usuario);
        return usuarioNovo;
    }

    public Usuario alterar(Usuario usuario) {
        usuario.setDataAtualizacao(new Date());
        return usuarioRepository.saveAndFlush(usuario);
    }

    public void excluir(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }
}
