package com.ufal.librarysystem.datasource;

import com.ufal.librarysystem.model.TelefonePessoa;

public class TelefonePessoaDAO extends AbstractDAO<TelefonePessoa> {
    public TelefonePessoaDAO() {
        super(TelefonePessoa.class);
    }

    @Override
    public TelefonePessoa getById(int id) {
        return super.getById(id);
    }

    @Override
    public void save(TelefonePessoa entity) {
        super.save(entity);
    }

    @Override
    public void update(TelefonePessoa entity) {
        super.update(entity);
    }

    @Override
    public void delete(TelefonePessoa entity) {
        super.delete(entity);
    }
}
