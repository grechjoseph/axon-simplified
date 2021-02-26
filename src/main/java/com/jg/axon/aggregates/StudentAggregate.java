package com.jg.axon.aggregates;

import com.jg.axon.events.command.student.CreateStudentCommand;
import com.jg.axon.events.command.student.DeleteStudentCommand;
import com.jg.axon.events.command.student.UpdateStudentCommand;
import com.jg.axon.events.event.student.StudentCreatedEvent;
import com.jg.axon.events.event.student.StudentDeletedEvent;
import com.jg.axon.events.event.student.StudentUpdatedEvent;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Set;
import java.util.UUID;

@Slf4j
@Aggregate
@NoArgsConstructor
public class StudentAggregate {

    @AggregateIdentifier
    private UUID id;
    private String firstName;
    private String lastName;
    private Set<UUID> subjectIds;

    // Create

    @CommandHandler
    public StudentAggregate(final CreateStudentCommand command) {
        this.id = UUID.randomUUID();
        this.firstName = command.getFirstName();
        this.lastName = command.getLastName();
        this.subjectIds = command.getSubjectIds();

        AggregateLifecycle.apply(StudentCreatedEvent.builder()
                .id(this.id)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .subjectIds(this.subjectIds)
                .build());
    }

    @EventSourcingHandler
    public void on(final StudentCreatedEvent event) {
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.subjectIds = event.getSubjectIds();
    }

    // Update

    @CommandHandler
    public void handle(final UpdateStudentCommand command) {
        // Validate
        AggregateLifecycle.apply(StudentUpdatedEvent.builder()
                .id(command.getId())
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .subjectIds(command.getSubjectIds())
                .build());
    }

    @EventSourcingHandler
    public void on(final StudentUpdatedEvent event) {
        this.firstName = event.getFirstName();
        this.lastName = event.getLastName();
        this.subjectIds = event.getSubjectIds();
    }

    // Delete

    @CommandHandler
    public void handle(final DeleteStudentCommand command) {
        AggregateLifecycle.apply(StudentDeletedEvent.builder()
                .id(command.getId())
                .build());
    }

    @EventSourcingHandler
    public void on(final StudentDeletedEvent event) {

    }
}
