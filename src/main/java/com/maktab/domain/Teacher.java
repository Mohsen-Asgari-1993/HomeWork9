package com.maktab.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "teacher_code", nullable = false, unique = true)
    private Long teacherCode;

    @Column(name = "birth_day")
    private LocalDate date;

    @Column(name = "salary")
    @Check(constraints = "salary > 0")
    private Long salary;

    @OneToOne(mappedBy = "teacher")
    private Address address;

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teacherCode=" + teacherCode +
                ", date=" + date +
                ", salary=" + salary +
                '}' + "\n" +
                "Address=" + address
                + "\n";
    }
}
