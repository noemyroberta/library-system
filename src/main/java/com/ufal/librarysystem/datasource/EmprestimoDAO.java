package com.ufal.librarysystem.datasource;

import com.ufal.librarysystem.model.Emprestimo;

public class EmprestimoDAO extends AbstractDAO<Emprestimo> {
    public EmprestimoDAO() {
        super(Emprestimo.class);
    }

    @Override
    public Emprestimo getById(int id) {
        return super.getById(id);
    }

    @Override
    public void save(Emprestimo entity) {
        super.save(entity);
    }

    @Override
    public void update(Emprestimo entity) {
        super.update(entity);
    }

    @Override
    public void delete(Emprestimo entity) {
        super.delete(entity);
    }
}
