package com.ufal.librarysystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_telefones_pessoas")
public class TelefonePessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tel_codigo")
    private int codigo;

    @ManyToOne
    @JoinColumn(name = "tel_pes_codigo", referencedColumnName = "pes_codigo")
    private Pessoa pessoa;

    @Column(name = "tel_numero", nullable = false)
    private String numero;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonePessoa that = (TelefonePessoa) o;
        return codigo == that.codigo && Objects.equals(pessoa, that.pessoa) && Objects.equals(numero, that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, pessoa, numero);
    }

    @Override
    public String toString() {
        return "TelefonePessoa{" +
                "codigo=" + codigo +
                ", pessoa=" + pessoa +
                ", numero='" + numero + '\'' +
                '}';
    }
}