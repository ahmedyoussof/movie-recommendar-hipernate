package com.movies.hibernate_data;

import java.util.List;

import org.hibernate.Session;

import com.movies.entities.Movie;

public interface Dao<T, ID> {

    public T findById(ID id);
    
    public boolean delete(ID id);
    
    public boolean update(T entity);
    
    public boolean insert(T entity);
    
    public void flush();
    
    public void clear();

    public void setSession(Session session);

    List<T> listMovies();

    public T save(Movie entity);
}
