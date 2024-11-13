package org.code.courses_students_service.clients.students;

import org.code.courses_students_service.clients.students.dto.StudentsReponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "students-service",
        url = "http://localhost:8081"
)
public interface StudentsClient {

    @GetMapping("/students/{documentNumber}")
    Optional<StudentsReponse> getStudentById(@PathVariable("documentNumber") String documentNumber);

    @GetMapping("/students/exist/{documentNumber}")
    Boolean existStudent(@PathVariable("documentNumber") String documentNumber);

}
