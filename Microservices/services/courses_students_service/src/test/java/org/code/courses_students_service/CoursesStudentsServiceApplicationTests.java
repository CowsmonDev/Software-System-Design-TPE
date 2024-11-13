package org.code.courses_students_service;

import org.code.courses_students_service.clients.courses.dto.CoursesReponse;
import org.code.courses_students_service.clients.students.dto.StudentsReponse;
import org.code.courses_students_service.models.CoursesStudent.dto.CoursesStudentWithInfoResponse;
import org.code.courses_students_service.models.CoursesStudent.dto.CoursesStudentsRequest;
import org.code.courses_students_service.models.CoursesStudent.dto.CoursesStudentsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoursesStudentsServiceApplicationTests {

    private WebTestClient webTestClient;
    private WebTestClient webTestClientCourses;
    private WebTestClient webTestClientStudents;

    @BeforeEach
    void setUp() {
        System.out.println("Setting up");
        webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8083")
                .build();

        webTestClientCourses = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8082")
                .build();

        webTestClientStudents = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8081")
                .build();
    }

    @Test
    void getCoursesStudents() {
        List<CoursesStudentsResponse> response = webTestClient.get()
                .uri("/courses_students")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(CoursesStudentsResponse.class)
                .returnResult().getResponseBody();

        assert response != null;
        response.forEach(System.out::println);
    }

    @Test
    void shouldCreateCoursesStudents() {
        List<CoursesReponse> coursesStudentsResponseList = webTestClientCourses.get()
                .uri("/courses")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(CoursesReponse.class)
                .returnResult().getResponseBody();

        List<StudentsReponse> studentsResponseList = webTestClientStudents.get()
                .uri("/students")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(StudentsReponse.class)
                .returnResult().getResponseBody();

        assert coursesStudentsResponseList != null;
        assert studentsResponseList != null;

        List<String> years = List.of("2021", "2022", "2023", "2024", "2025");

        studentsResponseList.forEach(student -> {
            System.out.println();
            System.out.println("Estamos creando las incripciones para el estudiante: " + student.documentNumber());
            coursesStudentsResponseList.forEach(course -> {
                if (Math.random() > 0.5) {
                    CoursesStudentsResponse coursesStudentsResponse = webTestClient.post()
                            .uri("/courses_students")
                            .bodyValue(
                                    new CoursesStudentsRequest(
                                            student.documentNumber(),
                                            course.id().toString(),
                                            years.get((int) (Math.random() * years.size())),
                                            "false"
                                    )
                            )
                            .exchange()
                            .expectStatus().isOk()
                            .expectBody(CoursesStudentsResponse.class)
                            .returnResult().getResponseBody();
                    assert coursesStudentsResponse != null;
                    System.out.println("    Lo Inscribimos al curso: " + coursesStudentsResponse.getCourseId());
                }
            });
        });

    }

    @Test
    void shouldGetCourseStudent() {
        List<CoursesStudentsResponse> responseList = webTestClient.get()
                .uri("/courses_students")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(CoursesStudentsResponse.class)
                .returnResult().getResponseBody();

        assert responseList != null;
        if (!responseList.isEmpty()) {
            CoursesStudentsResponse r = responseList.get(0);
            CoursesStudentWithInfoResponse response = webTestClient.get()
                    .uri("/courses_students/" + r.getCourseId() + "/" + r.getStudentDocumentNumber())
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody(CoursesStudentWithInfoResponse.class)
                    .returnResult().getResponseBody();

            assert response != null;
            System.out.println(response);
        }

    }


}
