package com.maktab.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_address")
    private String postalAddress;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
