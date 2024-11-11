package org.code.student_service.repositories;

import org.code.student_service.models.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Optional<Student> findByNumeroLibreta(String libreta);

    Optional<Student> findByGender(String genero);

    Optional<Student> findByResidenceCity(String city);


}
