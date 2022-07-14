package com.example.arqui.StudentService.controller;

import com.example.arqui.StudentService.model.Student;
import com.example.arqui.StudentService.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/apistudents")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    public StudentService studentService;


    @PostMapping("/agregar")
    public  ResponseEntity<?> guardarCurso(@RequestBody Student student){
        studentService.guardar(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getstudent",produces = "application/json")
    public List<Student>  listacursos(){
        List<Student> listaCursos = studentService.getAll();
        return listaCursos;
    }

    @GetMapping(path = "/student/{id}")
    public Optional<Student> getCursoById(@PathVariable("id") Integer id){
        return studentService.obtenerporId(id);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> update(@RequestBody Student curso, @PathVariable Integer id) {
        try {
            Student student1 = studentService.getCurso(id);
            curso.setId(id);
            studentService.guardar(curso);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/eliminar/{id}")
    public  ResponseEntity<?> eliminarCurso(@PathVariable("id") Integer id, Model modelo){
        studentService.eliminar(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


}
