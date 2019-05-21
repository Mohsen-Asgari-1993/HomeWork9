package com.maktab;

import com.maktab.domain.Teacher;
import com.maktab.repository.impl.TeacherDAOImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        TeacherDAOImpl teacherDAOImpl = new TeacherDAOImpl(factory);

        teacherDAOImpl.create(new Teacher(0L, "ali", "mohammadi", 1454L, LocalDate.of(1989, 5, 14), 145L));
        teacherDAOImpl.create(new Teacher(0L, "mohsen", "asgari", 1958L, LocalDate.of(1993, 1, 30), 2500L));
        teacherDAOImpl.create(new Teacher(0L, "siavash", "ahadi", 1777L, LocalDate.of(2000, 12, 1), 980L));
        teacherDAOImpl.create(new Teacher(0L, "akbar", "Erfani", 7852L, LocalDate.of(1977, 3, 25), 4500L));

    }
}
