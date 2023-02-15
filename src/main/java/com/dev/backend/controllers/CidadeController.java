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

import com.dev.backend.entities.Cidade;
import com.dev.backend.services.CidadeServices;

@RestController
@RequestMapping("api/cidade")
public class CidadeController extends EntityException {

    @Autowired
    private CidadeServices cidadeServices;

    @GetMapping("/")
    public List<Cidade> buscarTodos() {
        return cidadeServices.buscarTodos();
    }

    @PostMapping("/")
    public Cidade inserir(@RequestBody @Valid Cidade cidade) {
        return cidadeServices.inserir(cidade);
    }

    @PutMapping("/")
    public Cidade alterar(@RequestBody @Valid Cidade cidade) {
        return cidadeServices.alterar(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        cidadeServices.Excluir(id);
        return ResponseEntity.ok().build();
    }
}
