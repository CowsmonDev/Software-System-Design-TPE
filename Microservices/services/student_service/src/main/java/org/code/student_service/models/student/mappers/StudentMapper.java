package org.code.student_service.models.student.mappers;

import org.code.student_service.models.student.Student;
import org.code.student_service.models.student.dto.StudentResponse;
import org.code.student_service.models.student.dto.StudentRequest;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.beans.FeatureDescriptor;
import java.util.Arrays;

@Service
public class StudentMapper {

    public Student toStudent(StudentRequest studentRequest){
        return Student.builder()
                .documentNumber(studentRequest.documentNumber())
                .numeroLibreta(studentRequest.numeroLibreta())
                .name(studentRequest.name())
                .lastName(studentRequest.lastName())
                .age(studentRequest.age())
                .gender(studentRequest.gender())
                .residenceCity(studentRequest.residenceCity())
                .build();
    }

    public StudentResponse toStudentResponse(Student student){
        return new StudentResponse(
                student.getDocumentNumber(),
                student.getNumeroLibreta(),
                student.getName(),
                student.getLastName(),
                String.valueOf(student.getAge()),
                student.getGender(),
                student.getResidenceCity()
        );
    }

    /**
     * Get null property names of an object to update
     * @param updatedStudent  object to update with new values from request
     * @return array of null property names of the object
     */
    public String[] getNullPropertyNames(Student updatedStudent) {
        final BeanWrapper wrapperSource = new BeanWrapperImpl(updatedStudent);
        return Arrays.stream(wrapperSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrapperSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

}
