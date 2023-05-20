package com.ufal.librarysystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_emprestimos")
public class Emprestimo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_codigo")
    private int codigo;

    @Column(name = "emp_data_devolucao", nullable = false)
    private String dataDevolucao;

    @Column(name = "emp_data_saida", nullable = false)
    private String dataSaida;

    @ManyToOne
    @JoinColumn(name = "emp_cli_pes_codigo", referencedColumnName = "cli_pes_codigo")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "emp_fun_pes_codigo", referencedColumnName = "fun_pes_codigo")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "emp_exe_codigo", referencedColumnName = "exe_codigo")
    private Exemplar exemplar;

    @Column(name = "emp_deletado", nullable = false)
    private boolean deletado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }


    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return codigo == that.codigo && deletado == that.deletado && Objects.equals(dataDevolucao, that.dataDevolucao) && Objects.equals(dataSaida, that.dataSaida) && Objects.equals(cliente, that.cliente) && Objects.equals(funcionario, that.funcionario) && Objects.equals(exemplar, that.exemplar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, dataDevolucao, dataSaida, cliente, funcionario, exemplar, deletado);
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "codigo=" + codigo +
                ", dataDevolucao='" + dataDevolucao + '\'' +
                ", dataSaida='" + dataSaida + '\'' +
                ", cliente=" + cliente +
                ", funcionario=" + funcionario +
                ", exemplar=" + exemplar +
                ", deletado=" + deletado +
                '}';
    }
}