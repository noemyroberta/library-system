package com.ufal.librarysystem.model;
import javax.persistence.*;
@Entity
@Table(name = "tb_exemplares")
public class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exe_codigo")
    private int codigo;

    @Column(name = "exe_quantidade", nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "exe_liv_codigo")
    private Livro livro;

    // getters and setters
}