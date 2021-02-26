package com.jg.axon.service;

import com.jg.axon.data.model.Subject;
import com.jg.axon.events.command.subject.CreateSubjectCommand;
import com.jg.axon.events.command.subject.DeleteSubjectCommand;
import com.jg.axon.events.command.subject.UpdateSubjectCommand;
import com.jg.axon.events.query.subject.FindSubjectsQuery;
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
public class SubjectService {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;
    private final EventStore eventStore;

    public void createSubject(final Subject subject) {
        commandGateway.send(CreateSubjectCommand.builder()
                .subjectName(subject.getSubjectName())
                .build());
    }

    public void updateSubject(final Subject subject) {
        commandGateway.send(UpdateSubjectCommand.builder()
                .id(subject.getId())
                .subjectName(subject.getSubjectName())
                .build());
    }

    public void deleteSubject(final UUID subjectId) {
        commandGateway.send(DeleteSubjectCommand.builder()
                .id(subjectId)
                .build());
    }

    public Subject getSubjectById(final UUID subjectId) {
        return queryGateway.query(new FindSubjectsQuery(subjectId, null), ResponseTypes.multipleInstancesOf(Subject.class))
                .join()
                .stream()
                .findFirst()
                .get();
    }

}
