package com.maktab.repository;

import com.maktab.domain.Student;

import java.util.List;

public interface StudentDAO extends BaseDAO<Student> {

    List<Student> searchByFirstName(String firstName);

    List<Student> searchByLastName(String lastName);

}
