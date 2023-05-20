package com.ufal.librarysystem.datasource;

import com.ufal.librarysystem.model.Livro;

public class LivroDAO extends AbstractDAO<Livro> {
    public LivroDAO() {
        super(Livro.class);
    }

    @Override
    public Livro getById(int id) {
        return super.getById(id);
    }

    @Override
    public void save(Livro entity) {
        super.save(entity);
    }

    @Override
    public void update(Livro entity) {
        super.update(entity);
    }

    @Override
    public void delete(Livro entity) {
        super.delete(entity);
    }
}
