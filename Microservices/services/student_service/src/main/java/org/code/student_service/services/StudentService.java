package org.code.student_service.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.code.student_service.models.student.Student;
import org.code.student_service.models.student.dto.StudentRequest;
import org.code.student_service.models.student.dto.StudentResponse;
import org.code.student_service.models.student.mappers.StudentMapper;
import org.code.student_service.repositories.StudentRepository;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentResponse> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponse)
                .collect(Collectors.toList());
    }

    public StudentResponse addStudent(StudentRequest studentRequest) {
        return studentMapper.toStudentResponse(studentRepository.save(studentMapper.toStudent(studentRequest)));

    }

    public StudentResponse getStudent(String documentNumber) {
        return studentRepository.findById(documentNumber)
                .map(studentMapper::toStudentResponse)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(String documentNumber) {
        studentRepository.deleteById(documentNumber);
    }

    public void updateStudent(String documentNumber, StudentRequest studentRequest) {
        Student student = studentRepository.findById(documentNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Student updatedStudent = studentMapper.toStudent(studentRequest);

        // Copy non-null properties from updatedStudent to student
        BeanUtils.copyProperties(
                updatedStudent,
                student,
                studentMapper.getNullPropertyNames(updatedStudent) // generate array of null properties of updatedStudent
        );

        studentRepository.save(student);
    }

    public Boolean existsStudent(String documentNumber) {
        return studentRepository.existsById(documentNumber);
    }

    public StudentResponse getStudentByLibreta(String libreta) {
        return studentRepository.findByNumeroLibreta(libreta)
                .map(studentMapper::toStudentResponse)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public StudentResponse getByGender(String genero) {
        return studentRepository.findByGender(genero)
                .map(studentMapper::toStudentResponse)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public StudentResponse getByResidenceCityAndCourse(String residenceCity, String course) {
        StudentResponse sr = studentRepository.findByResidenceCity(residenceCity)
                .map(studentMapper::toStudentResponse)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return sr;
    }
}
