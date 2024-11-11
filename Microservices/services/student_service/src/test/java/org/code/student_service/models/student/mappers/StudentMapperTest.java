package org.code.student_service.models.student.mappers;

import org.code.student_service.models.student.Student;
import org.code.student_service.models.student.dto.StudentRequest;
import org.code.student_service.models.student.dto.StudentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    void toStudent() {

        StudentRequest studentRequest = new StudentRequest(
                "DOC12345678",
                "LIB1234567",
                "John",
                "Doe",
                25,
                "M",
                "CABA"
        );

        Student student = studentMapper.toStudent(studentRequest);

        assertEquals(studentRequest.documentNumber(), student.getDocumentNumber());
        assertEquals(studentRequest.numeroLibreta(), student.getNumeroLibreta());
        assertEquals(studentRequest.name(), student.getName());
        assertEquals(studentRequest.lastName(), student.getLastName());
        assertEquals(studentRequest.age(), student.getAge());
        assertEquals(studentRequest.gender(), student.getGender());
        assertEquals(studentRequest.residenceCity(), student.getResidenceCity());

        System.out.println(student);
        System.out.println(studentRequest);

    }

    @Test
    void toStudentResponse() {
        Student student = Student.builder()
                .documentNumber("DOC12345678")
                .numeroLibreta("LIB1234567")
                .name("John")
                .lastName("Doe")
                .age(25)
                .gender("M")
                .residenceCity("CABA")
                .build();

        StudentResponse studentResponse = studentMapper.toStudentResponse(student);

        assertEquals(student.getDocumentNumber(), studentResponse.documentNumber());
        assertEquals(student.getNumeroLibreta(), studentResponse.numeroLibreta());
        assertEquals(student.getName(), studentResponse.name());
        assertEquals(student.getLastName(), studentResponse.lastName());
        // convert int to string
        assertEquals(String.valueOf(student.getAge()), studentResponse.age());
        assertEquals(student.getGender(), studentResponse.gender());
        assertEquals(student.getResidenceCity(), studentResponse.residenceCity());

    }

}