package com.ufal.librarysystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_clientes")
public class Cliente implements Serializable {

    @OneToOne
    @JoinColumn(name = "cli_pes_codigo", referencedColumnName = "pes_codigo")
    @Id
    private Pessoa pessoa;

    @Column(name = "cli_deletado", nullable = false)
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
        Cliente cliente = (Cliente) o;
        return Objects.equals(pessoa, cliente.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pessoa);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "pessoa=" + pessoa +
                ", deletado=" + deletado +
                '}';
    }
}