package org.example.hn_ks24_cntt4_doanngocduy1.controller;

import lombok.RequiredArgsConstructor;
import org.example.hn_ks24_cntt4_doanngocduy1.model.entity.Student;
import org.example.hn_ks24_cntt4_doanngocduy1.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student target = studentService.findStudentById(id);
        if (target == null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(target ,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        if (student == null || student.getFullName() == null || student.getEmail() == null || student.getGpa() == null){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(studentService.createStudent(student) ,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable Long id, @RequestBody Student student){
        Student target = studentService.findStudentById(id);
        if (target == null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(studentService.putStudent(id, student) ,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        Student target = studentService.findStudentById(id);
        if (target == null){
            return ResponseEntity.notFound().build();
        }
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
