package com.movies.hibernate_data;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import com.movies.utils.HibernateUtil;

public abstract class AbstractDao<T, ID extends Serializable> implements Dao<T, ID> {

    private Class<T> persistentClass;
    private Session session;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void setSession(Session session) {
        this.session = session;
    }

    protected Session getSession() {
        if (this.session == null) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        return this.session;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public T findById(ID id) {
        return (T) getSession().load(this.getPersistentClass(), id);
    }
    
    @Override
    public List<T> listMovies() {
        return this.findByCriteria();
    }

    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(Criterion ... criterion){
        Criteria crit = this.getSession().createCriteria(this.getPersistentClass());
        
        for(Criterion c: criterion){
            crit.add(c);
        }
        return (List<T>) crit.list();   
    }


    @Override
    public void flush() {
        this.getSession().flush();

    }

    @Override
    public void clear() {
        this.getSession().clear();

    }

}
