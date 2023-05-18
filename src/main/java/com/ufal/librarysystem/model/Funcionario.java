package com.ufal.librarysystem.model;
import javax.persistence.*;
@Entity
@Table(name = "tb_funcionarios")
public class Funcionario {
    @Id
    @Column(name = "fun_pes_codigo")
    private int codigo;

    @OneToOne
    @MapsId
    private Pessoa pessoa;

    // getters and setters
}
