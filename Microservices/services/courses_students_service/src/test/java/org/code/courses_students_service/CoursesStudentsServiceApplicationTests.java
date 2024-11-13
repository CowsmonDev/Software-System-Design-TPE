package org.code.courses_students_service;

import org.code.courses_students_service.models.CoursesStudent.dto.CoursesStudentsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebClient
class CoursesStudentsServiceApplicationTests {

	private WebTestClient webTestClient;

	@BeforeEach
	void setUp() {
		System.out.println("Setting up");
		webTestClient = WebTestClient.bindToServer()
				.baseUrl("http://localhost:8083")
				.build();
	}

	@Test
	void getCoursesStudents() {
		webTestClient.get().uri("/courses_students")
				.exchange()
				.expectStatus().isOk();
	}


}
