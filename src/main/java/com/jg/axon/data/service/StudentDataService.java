package com.jg.axon.data.service;

import com.jg.axon.data.model.Student;
import com.jg.axon.data.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentDataService {

    private final StudentRepository studentRepository;

    public void createStudent(final Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(final Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(final UUID studentId) {
        studentRepository.delete(getStudentById(studentId));
    }

    public Student getStudentById(final UUID studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student with ID [" + studentId +"] not found."));
    }

}
