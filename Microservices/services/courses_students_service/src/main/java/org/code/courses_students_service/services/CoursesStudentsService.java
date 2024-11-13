package org.code.courses_students_service.services;

import lombok.AllArgsConstructor;
import org.code.courses_students_service.clients.courses.CoursesClient;
import org.code.courses_students_service.clients.courses.dto.CoursesReponse;
import org.code.courses_students_service.clients.students.StudentsClient;
import org.code.courses_students_service.clients.students.dto.StudentsReponse;
import org.code.courses_students_service.models.CoursesStudent.CoursesStudents;
import org.code.courses_students_service.models.CoursesStudent.dto.CoursesStudentsRequest;
import org.code.courses_students_service.models.CoursesStudent.dto.CoursesStudentsResponse;
import org.code.courses_students_service.models.CoursesStudent.mappers.CoursesStudentsMapper;
import org.code.courses_students_service.models.CoursesStudent.serializers.CoursesStudentsId;
import org.code.courses_students_service.repositories.CoursesStudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CoursesStudentsService {

    private final CoursesStudentsRepository coursesStudentsRepository;
    private final CoursesStudentsMapper coursesStudentsMapper;

    private final CoursesClient coursesClient;
    private final StudentsClient studentsClient;

    public List<CoursesStudentsResponse> getCoursesStudents() {
        return coursesStudentsRepository.findAll()
                .stream()
                .map(coursesStudentsMapper::toCoursesStudentsResponse)
                .toList();
    }

    public CoursesStudentsResponse getCourseStudent(String idCourse, String idStudent) {

        CoursesReponse course = coursesClient.getCourseById(Integer.parseInt(idCourse))
                .orElseThrow(() -> new RuntimeException("Course not found"));

        StudentsReponse student = studentsClient.getStudentById(idStudent)
                .orElseThrow(() -> new RuntimeException("Student not found"));


        return coursesStudentsRepository.findById(new CoursesStudentsId(idStudent, idCourse))
                .map(coursesStudents -> coursesStudentsMapper.toCoursesStudentsWithInfoResponse(coursesStudents, course, student))
                .orElseThrow(() -> new RuntimeException("Course student not found"));
    }

    public CoursesStudentsResponse createCourseStudent(CoursesStudentsRequest coursesStudentsRequest) {

        if(!coursesClient.existsCourse(Integer.valueOf(coursesStudentsRequest.courseId())))
            throw new RuntimeException("Course not found");

        if(! studentsClient.existStudent(coursesStudentsRequest.studentDocumentNumber()))
            throw new RuntimeException("Student not found");


        return coursesStudentsMapper.toCoursesStudentsResponse(
                coursesStudentsRepository.save(
                        coursesStudentsMapper.toCoursesStudents(coursesStudentsRequest)
                )
        );

    }

    public void deleteCourseStudent(String idCourse, String idStudent) {
        coursesStudentsRepository.deleteById(new CoursesStudentsId(idStudent, idCourse));
    }

    public void updateCourseStudent(String idCourse, String idStudent, CoursesStudentsRequest coursesStudentsRequest) {
        CoursesStudents coursesStudents = coursesStudentsRepository.findById(new CoursesStudentsId(idStudent, idCourse))
                .orElseThrow(() -> new RuntimeException("Course student not found"));

        coursesStudents.setId(new CoursesStudentsId(idStudent, idCourse));
        coursesStudents.setYearEntry(coursesStudentsRequest.yearEntry());
        coursesStudents.setIsGraduated(coursesStudentsRequest.isGraduated());

        coursesStudentsRepository.save(coursesStudents);
    }


}
