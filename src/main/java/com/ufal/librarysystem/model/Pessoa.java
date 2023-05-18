package com.ufal.librarysystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pes_codigo")
    private int codigo;

    @Column(name = "pes_nome", nullable = false)
    private String nome;

    @Column(name = "pes_cpf", nullable = false)
    private String cpf;

    @Column(name = "pes_data_nascimento", nullable = false)
    private String dataNascimento;

    @Column(name = "pes_complemento")
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "pes_bai_codigo")
    private Bairro bairro;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<TelefonePessoa> telefones;

    // getters and setters
}