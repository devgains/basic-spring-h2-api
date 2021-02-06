package com.devgains.basicspringapi.repository;

import com.devgains.basicspringapi.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByGradeGreaterThanEqual(double grade);

}