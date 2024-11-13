package org.code.courses_students_service.clients.courses;

import org.code.courses_students_service.clients.courses.dto.CoursesReponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "courses-service",
        url = "http://localhost:8082"
)
public interface CoursesClient {

    @GetMapping("/courses/{id}")
    Optional<CoursesReponse> getCourseById(@PathVariable("id") Integer id);

    @GetMapping("/courses/exists/{id}")
    Boolean existsCourse(@PathVariable("id") Integer id);

}
