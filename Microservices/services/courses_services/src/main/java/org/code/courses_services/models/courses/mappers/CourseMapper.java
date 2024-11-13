package org.code.courses_services.models.courses.mappers;

import org.code.courses_services.models.courses.Course;
import org.code.courses_services.models.courses.dto.CourseRequest;
import org.code.courses_services.models.courses.dto.CourseResponse;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.Arrays;

public class CourseMapper {

    public static Course toCourse(CourseRequest courseRequest) {
        return Course.builder()
                .name(courseRequest.name())
                .build();
    }

    public static CourseResponse toCourseResponse(Course course) {
        return new CourseResponse(
                course.getId(),
                course.getName()
        );
    }

    public static String[] getNullPropertyNames(Course updatedCourse){
        final BeanWrapper wrapperSource = new BeanWrapperImpl(updatedCourse);
        return Arrays.stream(wrapperSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(name -> wrapperSource.getPropertyValue(name) == null)
                .toArray(String[]::new);
    }

}
