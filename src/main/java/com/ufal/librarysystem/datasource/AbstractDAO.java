package com.ufal.librarysystem.datasource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class AbstractDAO<T> {
    private final Class<T> entityClass;
    private final SessionFactory sessionFactory;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public T getById(int id) {
        Session session = sessionFactory.openSession();
        T entity = session.get(entityClass, id);
        session.close();
        return entity;
    }

    public void save(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        System.out.println("Cadastrando novo "+ entityClass.getTypeName() + ": " +entity.toString());
        transaction.commit();
        session.close();
    }

    public void update(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Atualizando "+ entityClass.getTypeName() + " com informações de: " +entity.toString());
        session.update(entity);
        transaction.commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Deletando "+ entityClass.getTypeName() + ": " +entity.toString());
        session.delete(entity);
        transaction.commit();
        session.close();
    }
}

