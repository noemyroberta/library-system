package com.ufal.librarysystem.datasource;

import com.ufal.librarysystem.model.Bairro;

public class BairroDAO extends AbstractDAO<Bairro> {
    public BairroDAO() {
        super(Bairro.class);
    }

    @Override
    public Bairro getById(int id) {
        return super.getById(id);
    }

    @Override
    public void save(Bairro entity) {
        super.save(entity);
    }

    @Override
    public void update(Bairro entity) {
        super.update(entity);
    }

    @Override
    public void delete(Bairro entity) {
        super.delete(entity);
    }
}
