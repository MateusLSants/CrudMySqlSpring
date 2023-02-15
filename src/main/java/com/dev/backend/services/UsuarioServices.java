package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.backend.entities.Usuario;
import com.dev.backend.repository.UsuarioRepository;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder encoder;

    public UsuarioServices(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario inserir(Usuario usuario) {
        String encodePass = this.encoder.encode(usuario.getSenha());
        usuario.setSenha(encodePass);
        usuario.setDataCriacao(new Date());
        Usuario usuarioNovo = usuarioRepository.saveAndFlush(usuario);
        return usuarioNovo;
    }

    public Usuario alterar(Usuario usuario) {
        String encodePass = this.encoder.encode(usuario.getSenha());
        usuario.setSenha(encodePass);
        usuario.setDataAtualizacao(new Date());
        return usuarioRepository.saveAndFlush(usuario);
    }

    public void excluir(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    public Boolean validarSenha(Usuario usuario) {
        String senha = usuarioRepository.getById(usuario.getId()).getSenha();
        boolean valid = encoder.matches(usuario.getSenha(), senha);
        return valid;
    }
}
