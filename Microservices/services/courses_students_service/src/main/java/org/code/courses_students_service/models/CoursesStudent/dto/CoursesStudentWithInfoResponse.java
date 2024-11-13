package org.code.courses_students_service.models.CoursesStudent.dto;


import lombok.*;
import org.code.courses_students_service.clients.courses.dto.CoursesReponse;
import org.code.courses_students_service.clients.students.dto.StudentsReponse;

@Getter
@Setter
public class CoursesStudentWithInfoResponse extends CoursesStudentsResponse {


    private final CoursesReponse course;
    private final StudentsReponse student;

    public CoursesStudentWithInfoResponse(String studentDocumentNumber, String courseId, String yearEntry, String isGraduated, CoursesReponse course, StudentsReponse student) {
        super(studentDocumentNumber, courseId, yearEntry, isGraduated);
        this.course = course;
        this.student = student;
    }

    @Override
    public String toString() {
        return "CoursesStudentWithInfoResponse{\n" +
                " yearEntry='" + getYearEntry() + '\'' +
                ", isGraduated='" + getIsGraduated() + '\'' +
                "\n course=" + course +
                "\n student=" + student +
                "\n}";
    }
}
