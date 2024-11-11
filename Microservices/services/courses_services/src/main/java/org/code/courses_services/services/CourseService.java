package org.code.courses_services.services;

import lombok.AllArgsConstructor;
import org.code.courses_services.models.courses.Course;
import org.code.courses_services.models.courses.dto.CourseRequest;
import org.code.courses_services.models.courses.dto.CourseResponse;
import org.code.courses_services.models.courses.mappers.CourseMapper;
import org.code.courses_services.repositories.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<CourseResponse> getCourses() {
        return courseRepository.findAll()
                .stream().map(CourseMapper::toCourseResponse)
                .collect(Collectors.toList());
    }

    public CourseResponse getCourse(Integer id) {
        return courseRepository.findById(id)
                .map(CourseMapper::toCourseResponse)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public CourseResponse createCourse(CourseRequest courseRequest) {
        return CourseMapper.toCourseResponse(
                courseRepository.save(CourseMapper.toCourse(courseRequest))
        );
    }

    public void updateCourse(Integer id, CourseRequest courseRequest) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Course updatedCourse = CourseMapper.toCourse(courseRequest);

        BeanUtils.copyProperties(
                updatedCourse,
                course,
                CourseMapper.getNullPropertyNames(updatedCourse)
        );

        courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }

    public Boolean existsCourse(Integer id) {
        return courseRepository.existsById(id);
    }
}
