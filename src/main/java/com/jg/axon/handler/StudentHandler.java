package com.jg.axon.handler;

import com.jg.axon.data.model.Student;
import com.jg.axon.data.service.StudentDataService;
import com.jg.axon.data.service.SubjectDataService;
import com.jg.axon.events.event.student.StudentCreatedEvent;
import com.jg.axon.events.event.student.StudentDeletedEvent;
import com.jg.axon.events.event.student.StudentUpdatedEvent;
import com.jg.axon.events.query.student.FindStudentsQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentHandler {

    private final StudentDataService studentDataService;
    private final SubjectDataService subjectDataService;

    @EventHandler
    public void on(final StudentCreatedEvent event) {
        studentDataService.createStudent(Student.builder()
                .id(event.getId())
                .firstName(event.getFirstName())
                .lastName(event.getLastName())
                .subjects(
                        event.getSubjectIds().stream()
                        .map(subjectDataService::getSubjectById)
                        .collect(Collectors.toSet())
                )
                .build());
    }

    @EventHandler
    public void on(final StudentUpdatedEvent event) {
        studentDataService.updateStudent(Student.builder()
                .id(event.getId())
                .firstName(event.getFirstName())
                .lastName(event.getLastName())
                .subjects(
                        event.getSubjectIds().stream()
                                .map(subjectDataService::getSubjectById)
                                .collect(Collectors.toSet())
                )
                .build());
    }

    @EventHandler
    public void on(final StudentDeletedEvent event) {
        studentDataService.deleteStudent(event.getId());
    }

    @QueryHandler
    public List<Student> handle(final FindStudentsQuery query) {
        return Collections.singletonList(studentDataService.getStudentById(query.getId()));
    }
}
