package org.code.courses_services;

import com.fasterxml.jackson.databind.JsonNode;
import org.code.courses_services.models.courses.dto.CourseRequest;
import org.code.courses_services.models.courses.dto.CourseResponse;
import org.code.courses_services.modules.JsonReaderFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest
class CoursesServicesApplicationTests {


    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8082")
                .build();
    }

    @Test
    void shouldGetCourses() {
        List<CourseResponse> response = webTestClient.get()
                .uri("/courses")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(CourseResponse.class)
                .returnResult()
                .getResponseBody();

        assert response != null;

        response.forEach(System.out::println);
    }

    @Test
    void shouldGetCourseById() {
        // obtain the list of courses to get the first course and know it exists
        List<CourseResponse> response = webTestClient.get()
                .uri("/courses")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(CourseResponse.class)
                .returnResult()
                .getResponseBody();

        // if the list is not empty, get the first course
        if (response != null && !response.isEmpty()) {
            CourseResponse course = response.get(0);

            CourseResponse courseResponse = webTestClient.get()
                    .uri("/courses/" + course.id())
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody(CourseResponse.class)
                    .returnResult()
                    .getResponseBody();

            assert courseResponse != null;

            System.out.println(courseResponse);
        }
    }

    @Test
    void shouldCreateCourses() {

        List<JsonNode> dataCourses = JsonReaderFile.readJsonFile("courses_data.json");

        dataCourses.forEach(course -> {

            CourseRequest courseRequest = new CourseRequest(
                    course.get("name").asText()
            );

            CourseResponse response = webTestClient.post()
                    .uri("/courses")
                    .bodyValue(courseRequest)
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody(CourseResponse.class)
                    .returnResult()
                    .getResponseBody();

            assert response != null;

            System.out.println("Course created: " + response);
        });
    }

    @Test
    void shouldUpdateCourse() {
        List<CourseResponse> response = webTestClient.get()
                .uri("/courses")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(CourseResponse.class)
                .returnResult()
                .getResponseBody();

        if (response != null && !response.isEmpty()) {
            CourseResponse course = response.get(0);

            CourseRequest courseRequest = new CourseRequest(
                    course.name() + " updated"
            );

            webTestClient.put()
                    .uri("/courses/" + course.id())
                    .bodyValue(courseRequest)
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody(CourseResponse.class)
                    .returnResult()
                    .getResponseBody();


        }
    }

    @Test
    void shouldDeleteCourse() {
        List<CourseResponse> response = webTestClient.get()
                .uri("/courses")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(CourseResponse.class)
                .returnResult()
                .getResponseBody();

        if (response != null && !response.isEmpty()) {
            CourseResponse course = response.get(0);

            webTestClient.delete()
                    .uri("/courses/" + course.id())
                    .exchange()
                    .expectStatus().isAccepted();
        }
    }

}
