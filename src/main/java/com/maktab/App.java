package com.maktab;

import com.maktab.repository.impl.StudentDAOImpl;
import com.maktab.repository.impl.TeacherDAOImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        TeacherDAOImpl teacherDAOImpl = new TeacherDAOImpl(factory);
//
//        teacherDAOImpl.create(new Teacher(0L, "ali", "mohammadi", 1454L,
//                LocalDate.of(1989, 5, 14), 145L));
//        teacherDAOImpl.create(new Teacher(0L, "mohsen", "asgari", 1958L,
//                LocalDate.of(1993, 1, 30), 2500L));
//        teacherDAOImpl.create(new Teacher(0L, "siavash", "ahadi", 1777L,
//                LocalDate.of(2000, 12, 1), 980L));
//        teacherDAOImpl.create(new Teacher(0L, "akbar", "Erfani", 7852L,
//                LocalDate.of(1977, 3, 25), 4500L));


        StudentDAOImpl studentDAO = new StudentDAOImpl(factory);
//        studentDAO.create(new Student(0L, "Taghi", "Taghavi"));
//        studentDAO.create(new Student(0L, "naghi", "naghavi"));
//        studentDAO.create(new Student(0L, "ali", "alavi"));


//        System.out.println();
//        System.out.println(studentDAO.searchByFirstName("agh"));
//        System.out.println();
//
//        System.out.println(teacherDAOImpl.showMinAndMaxSalary());
//        System.out.println();
//
//        System.out.println(teacherDAOImpl.showOldAndYoung());

//        System.out.println(teacherDAOImpl.findAllByCity("Tehran"));

        System.out.println(teacherDAOImpl.findAllByNumberAndCity("Tehran", "0912"));

//        System.out.println(teacherDAOImpl.findAllByNumberStarts("0912"));

//        System.out.println(studentDAO.findAllByCity("Tehran"));


    }
}
