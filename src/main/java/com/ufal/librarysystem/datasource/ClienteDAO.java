package com.ufal.librarysystem.datasource;

import com.ufal.librarysystem.model.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente> {
    public ClienteDAO() {
        super(Cliente.class);
    }

    @Override
    public Cliente getById(int id) {
        return super.getById(id);
    }

    @Override
    public void save(Cliente entity) {
        super.save(entity);
    }

    @Override
    public void update(Cliente entity) {
        super.update(entity);
    }

    @Override
    public void delete(Cliente entity) {
        super.delete(entity);
    }
}
