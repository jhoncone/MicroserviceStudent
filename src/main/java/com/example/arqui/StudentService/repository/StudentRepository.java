package com.example.arqui.StudentService.repository;

import com.example.arqui.StudentService.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
