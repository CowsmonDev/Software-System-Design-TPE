package org.code.courses_students_service.clients.students.dto;

public record StudentsReponse(
        String documentNumber,
        String numeroLibreta,
        String name,
        String lastName,
        String age,
        String gender,
        String residenceCity
) {
}
