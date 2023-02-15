package com.dev.backend.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "estado")
@Data
public class Estado{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank()
    private String nome;

    @NotBlank()
    private String sigla;

    @Temporal(TemporalType.TIMESTAMP)
    public Date dataCriacao;
    
    @Temporal(TemporalType.TIMESTAMP)
    public Date dataAtualizacao;
}
