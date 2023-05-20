package com.ufal.librarysystem.datasource;

import com.ufal.librarysystem.model.Exemplar;

public class ExemplarDAO extends AbstractDAO<Exemplar> {
    public ExemplarDAO() {
        super(Exemplar.class);
    }

    @Override
    public Exemplar getById(int id) {
        return super.getById(id);
    }

    @Override
    public void save(Exemplar entity) {
        super.save(entity);
    }

    @Override
    public void update(Exemplar entity) {
        super.update(entity);
    }

    @Override
    public void delete(Exemplar entity) {
        super.delete(entity);
    }
}
