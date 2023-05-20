package com.ufal.librarysystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_generos")
public class Genero implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gen_codigo")
    private int codigo;

    @Column(name = "gen_genero", nullable = false)
    private String genero;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero1 = (Genero) o;
        return codigo == genero1.codigo && Objects.equals(genero, genero1.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, genero);
    }

    @Override
    public String toString() {
        return "Genero{" +
                "codigo=" + codigo +
                ", genero='" + genero + '\'' +
                '}';
    }
}
