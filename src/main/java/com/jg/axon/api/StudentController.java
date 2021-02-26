package com.jg.axon.api;

import com.jg.axon.data.model.Student;
import com.jg.axon.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public void createStudent(@RequestBody final Student student) {
        studentService.createStudent(student);
    }

    @PutMapping("/{studentId}")
    public void updateStudent(@RequestBody final Student student, @PathVariable final UUID studentId) {
        studentService.updateStudent(Student.builder()
                .id(studentId)
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .subjectIds(student.getSubjectIds())
                .build());
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable final UUID studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable final UUID studentId) {
        return studentService.getStudentById(studentId);
    }

}
