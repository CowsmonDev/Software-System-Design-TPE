package org.code.courses_students_service.controllers;

import lombok.AllArgsConstructor;
import org.code.courses_students_service.models.CoursesStudent.dto.CoursesStudentsRequest;
import org.code.courses_students_service.models.CoursesStudent.dto.CoursesStudentsResponse;
import org.code.courses_students_service.services.CoursesStudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/courses_students")
public class CoursesStudentsControllers {
    private final CoursesStudentsService coursesStudentsService;

    @GetMapping
    public ResponseEntity<List<CoursesStudentsResponse>> getCoursesStudents() {
        return ResponseEntity.ok(coursesStudentsService.getCoursesStudents());
    }

    @GetMapping("/{id_course}/{id_student}")
    public ResponseEntity<CoursesStudentsResponse> getCourseStudent(@PathVariable String id_course, @PathVariable String id_student) {
        return ResponseEntity.ok(coursesStudentsService.getCourseStudent(id_course, id_student));
    }


    @PostMapping
    public ResponseEntity<CoursesStudentsResponse> createCourseStudent(@RequestBody CoursesStudentsRequest coursesStudentsRequest) {
        return ResponseEntity.ok(coursesStudentsService.createCourseStudent(coursesStudentsRequest));
     }

    @DeleteMapping("/{id_course}/{id_student}")
    public ResponseEntity<Void> deleteCourseStudent(@PathVariable String id_course, @PathVariable String id_student) {
        coursesStudentsService.deleteCourseStudent(id_course, id_student);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id_course}/{id_student}")
    public ResponseEntity<Void> updateCourseStudent(@PathVariable String id_course, @PathVariable String id_student, @RequestBody CoursesStudentsRequest coursesStudentsRequest) {
        coursesStudentsService.updateCourseStudent(id_course, id_student, coursesStudentsRequest);
        return ResponseEntity.noContent().build();
    }



}
