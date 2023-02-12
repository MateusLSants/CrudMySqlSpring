package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> { }
