package org.code.courses_services.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.code.courses_services.models.courses.dto.CourseRequest;
import org.code.courses_services.models.courses.dto.CourseResponse;
import org.code.courses_services.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getCourses() {
        return ResponseEntity.ok(courseService.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getCourse(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.getCourse(id));
    }

    @PostMapping
    public ResponseEntity<CourseResponse> createCourse(@RequestBody @Valid CourseRequest courseRequest) {
        return ResponseEntity.ok(courseService.createCourse(courseRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable Integer id, @RequestBody @Valid CourseRequest courseRequest) {
        courseService.updateCourse(id, courseRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsCourse(@PathVariable Integer id) {
        System.out.println("ENTRO A EXIST");
        System.out.println(id);
        return ResponseEntity.ok(courseService.existsCourse(id));
    }




}
