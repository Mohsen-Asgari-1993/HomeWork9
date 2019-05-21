package com.maktab.repository.impl;

import com.maktab.domain.Teacher;
import com.maktab.repository.TeacherDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TeacherDAOImpl extends BaseDAOImpl<Teacher> implements TeacherDAO {

    private final String ENTITY_NAME = "Teacher";

    public TeacherDAOImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    public List<Teacher> findAll() {
        try (Session session = factory.openSession()) {
            List<Teacher> list = session.createQuery("from Teacher ", Teacher.class).list();
            return list;
        }
    }

    @Override
    public void deleteByTeacherCode(Long tCode) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.createQuery("delete Teacher t where t.teacherCode = " + tCode).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Teacher> showOldAndYoung() {
        Session session = factory.openSession();
        List<Teacher> list = session.createQuery("from Teacher  where date =(" +
                " select max(date) from Teacher ) " +
                "or date = (select min(date) from Teacher )", Teacher.class)
                .getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Teacher> showMinAndMaxSalary() {
        Session session = factory.openSession();

        List<Teacher> list = session.createQuery("from Teacher where salary =(" +
                " select max(salary) from Teacher ) " + "" +
                "or salary = (select min(salary) from Teacher )", Teacher.class)
                .getResultList();

        session.close();
        return list;
    }

    @Override
    protected String getEntityName() {
        return ENTITY_NAME;
    }
}
