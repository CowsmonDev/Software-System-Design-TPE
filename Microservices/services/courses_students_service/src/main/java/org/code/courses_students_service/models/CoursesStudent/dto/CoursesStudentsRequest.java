package org.code.courses_students_service.models.CoursesStudent.dto;

public record CoursesStudentsRequest(
        String studentDocumentNumber,
        String courseId,
        String yearEntry,
        String isGraduated
) {
}
