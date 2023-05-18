package com.ufal.librarysystem.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_telefones_pessoas")
public class TelefonePessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tel_codigo")
    private int codigo;

    @ManyToOne
    @JoinColumn(name = "tel_pes_codigo")
    private Pessoa pessoa;

    @Column(name = "tel_numero", nullable = false)
    private String numero;

    // getters and setters
}