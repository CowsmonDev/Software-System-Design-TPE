package org.code.courses_students_service.models.CoursesStudent.serializers;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CoursesStudentsId implements Serializable {

    @Column(name = "student_document_number")
    private String studentDocumentNumber;
    @Column(name = "course_id")
    private String courseId;


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CoursesStudentsId that = (CoursesStudentsId) obj;

        return Objects.equals(studentDocumentNumber, that.getStudentDocumentNumber()) && (Objects.equals(courseId, that.getCourseId()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentDocumentNumber, courseId);
    }
}
