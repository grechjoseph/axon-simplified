package com.jg.axon.service;

import com.jg.axon.data.model.Student;
import com.jg.axon.events.command.student.CreateStudentCommand;
import com.jg.axon.events.command.student.DeleteStudentCommand;
import com.jg.axon.events.command.student.UpdateStudentCommand;
import com.jg.axon.events.query.student.FindStudentsQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;
    private final EventStore eventStore;

    public void createStudent(final Student student) {
        commandGateway.send(CreateStudentCommand.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .subjectIds(student.getSubjectIds())
                .build());
    }

    public void updateStudent(final Student student) {
        commandGateway.send(UpdateStudentCommand.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .subjectIds(student.getSubjectIds())
                .build());
    }

    public void deleteStudent(final UUID studentId) {
        commandGateway.send(DeleteStudentCommand.builder()
                .id(studentId)
                .build());
    }

    public Student getStudentById(final UUID studentId) {
        return queryGateway.query(new FindStudentsQuery(), ResponseTypes.multipleInstancesOf(Student.class))
                .join()
                .stream()
                .findFirst()
                .get();
    }

}
