package com.dev.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entities.Usuario;
import com.dev.backend.services.UsuarioServices;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioServices usuarioServices;

    @GetMapping("/")
    public List<Usuario> buscarTodos() {
        return usuarioServices.buscarTodos();
    }

    @PostMapping("/")
    public Usuario inserir(@RequestBody Usuario usuario) {
        return usuarioServices.inserir(usuario);
    }

    @PutMapping("/")
    public Usuario alterar(@RequestBody Usuario usuario) {
        return usuarioServices.alterar(usuario);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        usuarioServices.excluir(id);
        return ResponseEntity.ok().build();
    }
}
