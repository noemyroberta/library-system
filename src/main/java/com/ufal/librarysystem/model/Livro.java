package com.ufal.librarysystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_livros")
public class Livro implements Serializable {
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
    @JoinColumn(name = "liv_gen_codigo", referencedColumnName = "gen_codigo")
    private Genero genero;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return codigo == livro.codigo && Objects.equals(titulo, livro.titulo) && Objects.equals(editora, livro.editora) && Objects.equals(dataLancamento, livro.dataLancamento) && Objects.equals(autor, livro.autor) && Objects.equals(sinopse, livro.sinopse) && Objects.equals(genero, livro.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, titulo, editora, dataLancamento, autor, sinopse, genero);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", editora='" + editora + '\'' +
                ", dataLancamento='" + dataLancamento + '\'' +
                ", autor='" + autor + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", genero=" + genero +
                '}';
    }
}