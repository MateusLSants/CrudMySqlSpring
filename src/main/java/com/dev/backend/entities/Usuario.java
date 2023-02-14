package com.dev.backend.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "O Campo nome nao deve ser nulo")
    private String nome;

    @NotBlank(message = "O Campo CPF nao deve ser nulo")
    private String cpf;

    @NotBlank(message = "O Campo email nao deve ser nulo")
    private String email;

    @NotBlank(message = "O Campo senha nao deve ser nulo")
    private String senha;

    @NotBlank(message = "O Campo nome nao deve ser nulo")
    private String endereco;

    @ManyToOne
    private Cidade cidade;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
