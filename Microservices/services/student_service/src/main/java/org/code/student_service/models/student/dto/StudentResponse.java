package org.code.student_service.models.student.dto;

public record StudentResponse(
        String documentNumber,
        String numeroLibreta,
        String name,
        String lastName,
        String age,
        String gender,
        String residenceCity
) {
}
