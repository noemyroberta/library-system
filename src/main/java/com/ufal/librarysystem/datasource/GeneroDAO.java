package com.ufal.librarysystem.datasource;

import com.ufal.librarysystem.model.Genero;

public class GeneroDAO extends AbstractDAO<Genero> {
    public GeneroDAO() {
        super(Genero.class);
    }

    @Override
    public Genero getById(int id) {
        return super.getById(id);
    }

    @Override
    public void save(Genero entity) {
        super.save(entity);
    }

    @Override
    public void update(Genero entity) {
        super.update(entity);
    }

    @Override
    public void delete(Genero entity) {
        super.delete(entity);
    }
}
