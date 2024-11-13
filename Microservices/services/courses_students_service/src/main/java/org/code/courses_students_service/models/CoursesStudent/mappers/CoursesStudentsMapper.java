package org.code.courses_students_service.models.CoursesStudent.mappers;

import org.code.courses_students_service.clients.courses.dto.CoursesReponse;
import org.code.courses_students_service.clients.students.dto.StudentsReponse;
import org.code.courses_students_service.models.CoursesStudent.CoursesStudents;
import org.code.courses_students_service.models.CoursesStudent.dto.*;
import org.code.courses_students_service.models.CoursesStudent.serializers.CoursesStudentsId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoursesStudentsMapper {

    public CoursesStudents toCoursesStudents(CoursesStudentsRequest coursesStudentsRequest) {
        return CoursesStudents.builder()
                .id(new CoursesStudentsId(
                        coursesStudentsRequest.studentDocumentNumber(),
                        coursesStudentsRequest.courseId())
                )
                .yearEntry(coursesStudentsRequest.yearEntry())
                .isGraduated(coursesStudentsRequest.isGraduated())
                .build();
    }


    public CoursesStudentsResponse toCoursesStudentsResponse(CoursesStudents coursesStudents) {
        return new CoursesStudentsResponse(
                coursesStudents.getId().getStudentDocumentNumber(),
                coursesStudents.getId().getCourseId(),
                coursesStudents.getYearEntry(),
                coursesStudents.getIsGraduated()
        );
    }

    public CoursesStudentWithInfoResponse toCoursesStudentsWithInfoResponse(CoursesStudents coursesStudents, CoursesReponse course, StudentsReponse student) {
        return new CoursesStudentWithInfoResponse(
                coursesStudents.getId().getStudentDocumentNumber(),
                coursesStudents.getId().getCourseId(),
                coursesStudents.getYearEntry(),
                coursesStudents.getIsGraduated(),
                course,
                student
        );
    }


}
