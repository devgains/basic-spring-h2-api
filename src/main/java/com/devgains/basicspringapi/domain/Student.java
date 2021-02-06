package com.devgains.basicspringapi.domain;

import lombok.*;

import javax.persistence.*;

@Entity(name = "student")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "course")
    private String course;

    @Column(name = "grade")
    private double grade;
}
