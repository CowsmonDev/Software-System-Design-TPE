package org.code.courses_students_service.models.CoursesStudent.dto;

public record Student(
        String documentNumber,
        String numeroLibreta,
        String name,
        String lastName,
        String age,
        String gender,
        String residenceCity
) {
}
