package com.ufal.librarysystem.model;
import javax.persistence.*;

@Entity
@Table(name = "tb_generos")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gen_codigo")
    private int codigo;

    @Column(name = "gen_genero", nullable = false)
    private String genero;

    // getters and setters
}
