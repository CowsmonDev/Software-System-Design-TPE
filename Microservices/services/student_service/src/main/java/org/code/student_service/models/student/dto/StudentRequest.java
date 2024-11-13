package org.code.student_service.models.student.dto;

public record StudentRequest(
        String documentNumber,
        String numeroLibreta,
        String name,
        String lastName,
        int age,
        String gender,
        String residenceCity
) {
}
