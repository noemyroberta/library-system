package com.ufal.librarysystem.datasource;

import com.ufal.librarysystem.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public HibernateUtil() {
        createSession();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            createSession();
        }
        return sessionFactory;
    }

    public static void createSession() {
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/db_biblioteca");
        config.setProperty("hibernate.connection.username", "localhost");
        config.setProperty("hibernate.connection.password", "");
        config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");

        config.setProperty("hibernate.connection.characterEncoding", "utf8");
        config.setProperty("hibernate.hbm2ddl.auto", "update");
        config.setProperty("hibernate.connection.autoReconnect", "true");
        config.setProperty("hibernate.show_sql", "false");

        config.addAnnotatedClass(Cliente.class);
        config.addAnnotatedClass(Exemplar.class);
        config.addAnnotatedClass(Bairro.class);
        config.addAnnotatedClass(Emprestimo.class);
        config.addAnnotatedClass(TelefonePessoa.class);
        config.addAnnotatedClass(Pessoa.class);
        config.addAnnotatedClass(Livro.class);
        config.addAnnotatedClass(Genero.class);
        config.addAnnotatedClass(Funcionario.class);

        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }
}