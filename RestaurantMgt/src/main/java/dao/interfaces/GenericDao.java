/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nick
 */
public interface GenericDao<T, ID extends Serializable> {

    Class<T> getEntityClass();

    T findById(final ID id);

    List<T> findAll();

    List<T> findByExample(final T exampleIntance);

    List<T> findByNamedQuery(final String queryName, Object... params);

    List<T> findByNamedQueryAndNamedParams(final String queryName, final Map<String, ? extends Object> params);

    int countAll();

    int countByExample(final T exampleInstance);

    T save(final T entity);
    
    void add(final T entity);

    void delete(final T entity);
}
