package com.ufal.librarysystem.model;
import javax.persistence.*;
import java.util.Objects;

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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplar exemplar = (Exemplar) o;
        return codigo == exemplar.codigo && quantidade == exemplar.quantidade && Objects.equals(livro, exemplar.livro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, quantidade, livro);
    }

    @Override
    public String toString() {
        return "Exemplar{" +
                "codigo=" + codigo +
                ", quantidade=" + quantidade +
                ", livro=" + livro +
                '}';
    }
}