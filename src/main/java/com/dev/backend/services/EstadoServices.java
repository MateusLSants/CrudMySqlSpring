package com.dev.backend.services;

import java.util.Date;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entities.Estado;
import com.dev.backend.repository.EstadoRepository;

@Service
public class EstadoServices {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }

    public Estado inserir(@Valid Estado estado) {
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar(@Valid Estado estado) {
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public void excluir(Long id) {
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }
}
