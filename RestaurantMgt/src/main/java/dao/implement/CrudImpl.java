/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implement;

import dao.interfaces.ICrudGeneral;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nick
 */
@Repository

public class CrudImpl<T> implements ICrudGeneral<T> {

    @Autowired
    private SessionFactory session;
    private Class<T> clazz;

    @Override
    public List<T> getList() {
        return session.getCurrentSession().createQuery("from" + clazz.getName()).list();
    }

    @Override
    public void create(T entity) {
        session.getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        session.getCurrentSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        session.getCurrentSession().delete(entity);
    }

    @Override
    public <T> T getEntitytById(int entityId) {
        return (T) session.getCurrentSession().get(clazz, entityId);
    }

}
