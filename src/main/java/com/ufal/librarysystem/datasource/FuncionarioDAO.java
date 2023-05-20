package com.ufal.librarysystem.datasource;

import com.ufal.librarysystem.model.Funcionario;

public class FuncionarioDAO extends AbstractDAO<Funcionario> {
    public FuncionarioDAO() {
        super(Funcionario.class);
    }

    @Override
    public Funcionario getById(int id) {
        return super.getById(id);
    }

    @Override
    public void save(Funcionario entity) {
        super.save(entity);
    }

    @Override
    public void update(Funcionario entity) {
        super.update(entity);
    }

    @Override
    public void delete(Funcionario entity) {
        super.delete(entity);
    }
}
