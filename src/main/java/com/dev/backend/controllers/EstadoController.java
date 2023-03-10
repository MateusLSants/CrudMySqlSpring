package com.dev.backend.controllers;

import java.util.List;

import com.dev.backend.Exceptions.EntityException;
import jakarta.validation.Valid;
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

import com.dev.backend.entities.Estado;
import com.dev.backend.services.EstadoServices;


@RestController
@RequestMapping("/api/estado")
public class EstadoController extends EntityException {
    
    @Autowired
    private EstadoServices estadoServices;

    @GetMapping("/")
    public List<Estado> buscarTodos() {
        return estadoServices.buscarTodos();
    }

    @PostMapping("/")
    public Estado inserir(@RequestBody @Valid Estado estado) {
        return estadoServices.inserir(estado);
    }

    @PutMapping("/")
    public Estado alterar(@RequestBody @Valid Estado estado) {
        return estadoServices.alterar(estado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        estadoServices.excluir(id);
        return ResponseEntity.ok().build();
    }
    
}
