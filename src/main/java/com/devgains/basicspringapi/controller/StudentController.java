package com.devgains.basicspringapi.controller;

import com.devgains.basicspringapi.domain.Student;
import com.devgains.basicspringapi.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
        final var studentOptional = studentRepository.findById(id);
        return studentOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Student> getStudentsWithGradeGreaterThanEqual(@RequestParam("minGrade") double minGrade) {
        return studentRepository.findByGradeGreaterThanEqual(minGrade);
    }

    @PostMapping
    public Student postStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentRepository.deleteById(id);
    }
}
