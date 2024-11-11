package org.code.student_service;

import com.fasterxml.jackson.databind.JsonNode;
import org.code.student_service.models.student.Student;
import org.code.student_service.models.student.dto.StudentRequest;
import org.code.student_service.models.student.dto.StudentResponse;
import org.code.student_service.modules.JsonReaderFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentServiceApplicationTests {

    private WebTestClient webTestClient;

    private List<StudentResponse> getAllStudents() {
        return Objects.requireNonNull(webTestClient.get().uri("/students")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(StudentResponse.class).returnResult().getResponseBody());
    }

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8081")
                .build();
    }

    @Test
    void shouldCreateStudents() {
        System.out.println("Loading Data from JSON file");
        List<JsonNode> data = JsonReaderFile.readJsonFile("student_data.json");
        data.forEach((student) -> {
            StudentResponse w = webTestClient.post().uri("/students")
                    .bodyValue(
                            Student.builder()
                                    .documentNumber(student.get("documentNumber").asText())
                                    .numeroLibreta(student.get("numeroLibreta").asText())
                                    .name(student.get("name").asText())
                                    .lastName(student.get("lastname").asText())
                                    .age(student.get("age").asInt())
                                    .gender(student.get("gender").asText())
                                    .residenceCity(student.get("residenceCity").asText())
                                    .build()
                    )
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody(StudentResponse.class).returnResult().getResponseBody();

            System.out.println("Student created: " + w);
        });
        System.out.println("Data loaded successfully");
    }

    @Test
    void shouldGetStudentById() {
        StudentResponse student = getAllStudents().get(0);


        StudentResponse result = Objects.requireNonNull(webTestClient.get().uri("/students/" + student.documentNumber())
                .exchange()
                .expectStatus().isOk()
                .expectBody(StudentResponse.class).returnResult().getResponseBody());

        assertEquals(student.documentNumber(), result.documentNumber());
        assertEquals(student.numeroLibreta(), result.numeroLibreta());
        assertEquals(student.name(), result.name());
        assertEquals(student.lastName(), result.lastName());
        assertEquals(student.age(), result.age());
    }


    @Test
    void shouldGetStudents() {
        List<StudentResponse> result = Objects.requireNonNull(webTestClient.get().uri("/students")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(StudentResponse.class).returnResult().getResponseBody());

        result.forEach(System.out::println);
    }

    @Test
    void shouldDeleteStudent() {
        List<StudentResponse> students = getAllStudents();
        if (students != null && !students.isEmpty()) {
            StudentResponse student = students.get(0);
            webTestClient.delete().uri("/students/" + student.documentNumber())
                    .exchange()
                    .expectStatus().isAccepted();
        }
    }

    @Test
    void shouldUpdateStudent() {
        //JsonNode data = JsonReaderFile.readJsonFile("student_data.json").get(0);
        List<StudentResponse> data = getAllStudents();
        if (data != null && !data.isEmpty()) {
            StudentResponse student = data.get(0);

            webTestClient.put().uri("/students/" + student.documentNumber())
                    .bodyValue(new StudentRequest(
                            student.documentNumber(),
                            student.numeroLibreta(),
                            student.name() + " Modified",
                            student.lastName(),
                            Integer.parseInt(student.age()),
                            student.gender(),
                            student.residenceCity()
                    ))
                    .exchange()
                    .expectStatus().isOk();
        }
    }


    @Test
    void shouldExistsStudent() {
        List<StudentResponse> data = getAllStudents();
        if (data != null && !data.isEmpty()) {
            StudentResponse student = data.get(0);

            Boolean result = Objects.requireNonNull(webTestClient.get().uri("/students/exists/" + student.documentNumber())
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody(Boolean.class).returnResult().getResponseBody());

            assertEquals(true, result);
        }
    }


}
