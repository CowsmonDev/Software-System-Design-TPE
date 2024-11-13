package org.code.courses_students_service.models.CoursesStudent;

import jakarta.persistence.*;
import lombok.*;
import org.code.courses_students_service.models.CoursesStudent.serializers.CoursesStudentsId;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class CoursesStudents {

    @EmbeddedId
    private CoursesStudentsId id;

    @Column(name = "year_entry")
    private String yearEntry;
    @Column(name = "is_graduated")
    private String isGraduated;

}
