package com.example.arqui.StudentService.service;

import com.example.arqui.StudentService.model.Student;

import com.example.arqui.StudentService.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    public StudentRepository studentRepository;
    public Student guardar(Student curso){
       return studentRepository.save(curso);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> obtenerporId(Integer id) {
        return studentRepository.findById(id);
    }

    public Student getCurso(Integer id) {
        return studentRepository.findById(id).get();
    }

    public void eliminar(Integer id) {
        studentRepository.deleteById(id);
    }
}
