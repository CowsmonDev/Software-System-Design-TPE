package org.code.courses_services.models.courses.mappers;

import org.code.courses_services.models.courses.Course;
import org.code.courses_services.models.courses.dto.CourseRequest;
import org.code.courses_services.models.courses.dto.CourseResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseMapperTest {

    @Test
    void toCourse() {
        CourseRequest courseRequest = new CourseRequest(
                "Math"
        );

        Course course = CourseMapper.toCourse(courseRequest);

        assertEquals(courseRequest.name(), course.getName());


    }

    @Test
    void toCourseResponse() {
        Course course = Course.builder()
                .id(1)
                .name("Math")
                .build();

        CourseResponse courseResponse = CourseMapper.toCourseResponse(course);

        assertEquals(course.getId(), courseResponse.id());
        assertEquals(course.getName(), courseResponse.name());


    }

}