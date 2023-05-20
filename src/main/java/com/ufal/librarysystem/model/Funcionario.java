package com.ufal.librarysystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionario implements Serializable {
    @OneToOne
    @JoinColumn(name = "fun_pes_codigo", referencedColumnName = "pes_codigo")
    @Id
    private Pessoa pessoa;

    @Column(name = "fun_deletado", nullable = false)
    private boolean deletado;

    public int getCodigo() {
        return pessoa.getCodigo();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(pessoa, that.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pessoa);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "pessoa=" + pessoa +
                ", deletado=" + deletado +
                '}';
    }
}
