package com.maktab.repository.impl;

import com.maktab.domain.Student;
import com.maktab.repository.StudentDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDAOImpl extends BaseDAOImpl<Student> implements StudentDAO {

    private final String ENTITY_NAME = "Student";

    public StudentDAOImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    public List<Student> searchByFirstName(String firstName) {

        Session session = factory.openSession();
        return session.createQuery(
                "from Student s where s.firstName like '%" + firstName + "%'",
                Student.class).list();
    }

    @Override
    public List<Student> searchByLastName(String lastName) {
        Session session = factory.openSession();
        return session.createQuery(
                "from Student s where s.lastName like '%" + lastName + "%'",
                Student.class).list();

    }

    @Override
    public List<Student> findAllByCity(String city) {
        Session session = factory.openSession();

        List<Student> list = session.createQuery("from Student s where not s.address.city = ?1"
                , Student.class).setParameter(1, city).list();
        return list;
    }

    @Override
    protected String getEntityName() {
        return ENTITY_NAME;
    }
}
