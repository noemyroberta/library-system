package com.ufal.librarysystem.model;
import javax.persistence.*;

@Entity
@Table(name = "tb_emprestimos")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_codigo")
    private int codigo;

    @Column(name = "emp_data_devolucao", nullable = false)
    private String dataDevolucao;

    @Column(name = "emp_data_saida", nullable = false)
    private String dataSaida;

    @ManyToOne
    @JoinColumn(name = "emp_cli_pes_codigo")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "emp_fun_pes_codigo")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "emp_exe_codigo")
    private Exemplar exemplar;

    // getters and setters
}