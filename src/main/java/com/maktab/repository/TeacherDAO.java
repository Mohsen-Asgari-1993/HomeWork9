package com.maktab.repository;

import com.maktab.domain.Teacher;

import java.util.List;

public interface TeacherDAO extends BaseDAO<Teacher> {

    List<Teacher> findAll();

    void deleteByTeacherCode(Long Tcode);

    List<Teacher> showOldAndYoung();

    List<Teacher> showMinAndMaxSalary();

}
