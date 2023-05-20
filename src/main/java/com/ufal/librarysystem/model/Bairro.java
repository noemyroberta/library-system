package com.ufal.librarysystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_bairros")
public class Bairro  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bai_codigo")
    private int codigo;

    @Column(name = "bai_bairro", nullable = false)
    private String bairro;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bairro bairro1 = (Bairro) o;
        return codigo == bairro1.codigo && Objects.equals(bairro, bairro1.bairro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, bairro);
    }

    @Override
    public String toString() {
        return "Bairro{" +
                "codigo=" + codigo +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}
