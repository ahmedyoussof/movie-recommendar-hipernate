package com.movies.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.movies.entities.Movie;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Movie.class);
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error while building factory");
        }
        
    }
    
    public static SessionFactory getSessionFactory() {
        
        return sessionFactory;
    }
    
}
