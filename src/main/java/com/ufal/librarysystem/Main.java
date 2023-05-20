package com.ufal.librarysystem;

import com.ufal.librarysystem.datasource.*;
import com.ufal.librarysystem.model.*;

public class Main {
    public static void main(String[] args) {
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        // Criação de um novo empréstimo
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataSaida("2023-05-18");
        emprestimo.setDataDevolucao("2023-06-22");

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.getById(17); // Obtém um cliente existente
        emprestimo.setCliente(cliente);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = funcionarioDAO.getById(25); // Obtém um funcionário existente
        emprestimo.setFuncionario(funcionario);

        ExemplarDAO exemplarDAO = new ExemplarDAO();
        Exemplar exemplar = exemplarDAO.getById(3); // Obtém um exemplar existente
        emprestimo.setExemplar(exemplar);

        emprestimoDAO.save(emprestimo);

        // Atualização de um empréstimo existente
        Emprestimo emprestimoExistente = emprestimoDAO.getById(1506);
        emprestimoExistente.setDataDevolucao("2023-06-01");
        emprestimoDAO.update(emprestimoExistente);

        // Remoção de um empréstimo existente, ou seja, modificando a coluna emp_deletado = 1
        Emprestimo emprestimoDesligado = emprestimoDAO.getById(1508);
        emprestimoDesligado.setDeletado(true);
        emprestimoDAO.update(emprestimoDesligado);

        // Deletar registro de um empréstimo existente
        Emprestimo emprestimoRemover = emprestimoDAO.getById(1511);
        emprestimoDAO.delete(emprestimoRemover);
    }
}
