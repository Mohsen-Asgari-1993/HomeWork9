package com.maktab.repository.impl;

import com.maktab.repository.BaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class BaseDAOImpl<E extends Serializable> implements BaseDAO<E> {

    protected static SessionFactory factory;

    public BaseDAOImpl(SessionFactory factory) {
        BaseDAOImpl.factory = factory;
    }

    protected abstract String getEntityName();

    @Override
    public void create(E e) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(e);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public E update(E e) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(e);
            session.getTransaction().commit();
            return e;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public E read(Serializable id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Object o = session.createQuery("from " + getEntityName() + " ent where ent.id = " + id).getSingleResult();
            session.getTransaction().commit();
            return (E) o;
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Serializable id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.createQuery("delete " + getEntityName() + " entity where entity.id = " + id).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
