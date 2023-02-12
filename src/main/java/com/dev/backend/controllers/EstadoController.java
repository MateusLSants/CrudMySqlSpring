package com.dev.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entities.Estado;
import com.dev.backend.services.EstadoServices;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {
    
    @Autowired
    private EstadoServices estadoServices;

    @GetMapping("/")
    public List<Estado> buscarTodos() {
        return estadoServices.buscarTodos();
    }

    @PostMapping("/")
    public Estado inserir(@RequestBody Estado estado) {
        return estadoServices.inserir(estado);
    }

    @PutMapping("/")
    public Estado alterar(@RequestBody Estado estado) {
        return estadoServices.alterar(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathParam("id") Long id) {
        estadoServices.excluir(id);
        return ResponseEntity.ok().build();
    }
    
}
