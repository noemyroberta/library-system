package com.ufal.librarysystem.datasource;

import com.ufal.librarysystem.model.Pessoa;

public class PessoaDAO extends AbstractDAO<Pessoa> {
    public PessoaDAO() {
        super(Pessoa.class);
    }

    @Override
    public Pessoa getById(int id) {
        return super.getById(id);
    }

    @Override
    public void save(Pessoa entity) {
        super.save(entity);
    }

    @Override
    public void update(Pessoa entity) {
        super.update(entity);
    }

    @Override
    public void delete(Pessoa entity) {
        super.delete(entity);
    }
}
