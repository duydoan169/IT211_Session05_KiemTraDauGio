package org.example.hn_ks24_cntt4_doanngocduy1.service;

import lombok.RequiredArgsConstructor;
import org.example.hn_ks24_cntt4_doanngocduy1.model.entity.Student;
import org.example.hn_ks24_cntt4_doanngocduy1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student findStudentById(Long id){
        return studentRepository.findStudentById(id);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student putStudent(Long id, Student student){
        student.setId(id);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
