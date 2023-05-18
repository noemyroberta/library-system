package com.ufal.librarysystem.model;
import javax.persistence.*;
@Entity
@Table(name = "tb_livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "liv_codigo")
    private int codigo;

    @Column(name = "liv_titulo", nullable = false)
    private String titulo;

    @Column(name = "liv_editora", nullable = false)
    private String editora;

    @Column(name = "liv_data_lancamento", nullable = false)
    private String dataLancamento;

    @Column(name = "liv_autor", nullable = false)
    private String autor;

    @Column(name = "liv_sinopse", nullable = false)
    private String sinopse;

    @ManyToOne
    @JoinColumn(name = "liv_gen_codigo")
    private Genero genero;

    // getters and setters
}