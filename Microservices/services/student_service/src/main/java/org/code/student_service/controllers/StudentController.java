package org.code.student_service.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.code.student_service.models.student.dto.StudentRequest;
import org.code.student_service.models.student.dto.StudentResponse;
import org.code.student_service.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody @Valid StudentRequest studentRequest) {
        return ResponseEntity.ok(studentService.addStudent(studentRequest));
    }

    @GetMapping("/{documentNumber}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable String documentNumber) {
        return ResponseEntity.ok(studentService.getStudent(documentNumber));
    }

    @DeleteMapping("/{documentNumber}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String documentNumber) {
        studentService.deleteStudent(documentNumber);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{documentNumber}")
    public ResponseEntity<Void> updateStudent(@PathVariable String documentNumber, @RequestBody @Valid StudentRequest studentRequest) {
        studentService.updateStudent(documentNumber, studentRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/exists/{documentNumber}")
    public ResponseEntity<Boolean> existsStudent(@PathVariable String documentNumber) {
        return ResponseEntity.ok(studentService.existsStudent(documentNumber));
    }


}
