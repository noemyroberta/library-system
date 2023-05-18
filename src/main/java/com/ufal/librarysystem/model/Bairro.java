package com.ufal.librarysystem.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_bairros")
public class Bairro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bai_codigo")
    private int codigo;

    @Column(name = "bai_bairro", nullable = false)
    private String bairro;

    // getters and setters
}
