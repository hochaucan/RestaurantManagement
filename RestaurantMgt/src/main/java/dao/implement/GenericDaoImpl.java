/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implement;

import dao.interfaces.GenericDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author Nick
 */
public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

    private final Class<T> persistenceClass;
    private static final String PERSISTENCE_UNIT_NAME = "RestaurantMgt_jar_1.0-SNAPSHOTPU";
   // private static EntityManagerFactory factory;
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//        entityManager = factory.createEntityManager();
    }

    public GenericDaoImpl(final Class<T> persistenceClass) {
        super();
        this.persistenceClass = persistenceClass;
    }

    @Override
    public Class<T> getEntityClass() {
        return persistenceClass;
    }

    @Override
    public T findById(ID id) {
        final T result = getEntityManager().find(persistenceClass, id);
        return result;
    }

    @Override
    public List<T> findAll() {
        return findByCriteria();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByExample(final T exampleIntance) {
        Session session = (Session) getEntityManager().getDelegate();
        Criteria crit = session.createCriteria(getEntityClass());
        final List<T> result = crit.list();
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByNamedQuery(final String queryName, Object... params) {
        Query query = getEntityManager().createNamedQuery(queryName);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        final List<T> result = (List<T>) query.getResultList();
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByNamedQueryAndNamedParams(final String queryName, final Map<String, ? extends Object> params) {
        Query query = getEntityManager().createNamedQuery(queryName);
        for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }
        final List<T> result = (List<T>) query.getResultList();
        return result;
    }

    @Override
    public int countAll() {
        return countByCriteria();
    }

    @Override
    public int countByExample(T exampleInstance) {
        Session session = (Session) getEntityManager().getDelegate();
        Criteria crit = session.createCriteria(getEntityClass());
        crit.setProjection(Projections.rowCount());
        crit.add(Example.create(exampleInstance));

        return (Integer) crit.list().get(0);
    }

    @Override
    public T save(T entity) {
        final T savedEntity = entityManager.merge(entity);//getEntityManager().merge(entity);
        return savedEntity;
    }

    @Override
    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Required
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected List<T> findByCriteria(final Criterion... criterion) {
        return findByCriteria(-1, -1, criterion);
    }

    /**
     * Use this inside subclasses as a convenience method.
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(final int firstResult,
            final int maxResults, final Criterion... criterion) {
        Session session = (Session) getEntityManager().getDelegate();
        Criteria crit = session.createCriteria(getEntityClass());

        for (final Criterion c : criterion) {
            crit.add(c);
        }

        if (firstResult > 0) {
            crit.setFirstResult(firstResult);
        }

        if (maxResults > 0) {
            crit.setMaxResults(maxResults);
        }

        final List<T> result = crit.list();
        return result;
    }

    protected int countByCriteria(Criterion... criterion) {
        Session session = (Session) getEntityManager().getDelegate();
        Criteria crit = session.createCriteria(getEntityClass());
        crit.setProjection(Projections.rowCount());

        for (final Criterion c : criterion) {
            crit.add(c);
        }

        return (Integer) crit.list().get(0);
    }

    @Override
    public void add(T entity) {
        entityManager.persist(entity);
    }
}
