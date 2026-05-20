package org.example.hn_ks24_cntt4_doanngocduy1.repository;

import org.example.hn_ks24_cntt4_doanngocduy1.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentById(Long id);
}
