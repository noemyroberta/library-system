package com.ufal.librarysystem.model;
import javax.persistence.*;

@Entity
@Table(name = "tb_clientes")
public class Cliente {
    @Id
    @Column(name = "cli_pes_codigo")
    private int codigo;

    @OneToOne
    @MapsId
    private Pessoa pessoa;

    // getters and setters
}