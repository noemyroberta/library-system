package com.ufal.librarysystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_pessoas")
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pes_codigo")
    private int codigo;

    @Column(name = "pes_nome", nullable = false)
    private String nome;

    @Column(name = "pes_cpf", nullable = false)
    private String cpf;

    @Column(name = "pes_data_nascimento", nullable = false)
    private String dataNascimento;

    @Column(name = "pes_complemento")
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "pes_bai_codigo")
    private Bairro bairro;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<TelefonePessoa> telefones;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public List<TelefonePessoa> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefonePessoa> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro=" + bairro +
                '}';
    }
}