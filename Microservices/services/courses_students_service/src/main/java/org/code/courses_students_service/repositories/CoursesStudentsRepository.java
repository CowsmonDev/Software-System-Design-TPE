package org.code.courses_students_service.repositories;

import org.code.courses_students_service.models.CoursesStudent.CoursesStudents;
import org.code.courses_students_service.models.CoursesStudent.serializers.CoursesStudentsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Repository
public interface CoursesStudentsRepository extends JpaRepository<CoursesStudents, CoursesStudentsId> {

    List<CoursesStudents> findByIdCourseId(String idCourse);

    List<CoursesStudents> findByIdStudentDocumentNumber(String idStudent);
}
