package org.code.courses_services.repositories;

import org.code.courses_services.models.courses.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
