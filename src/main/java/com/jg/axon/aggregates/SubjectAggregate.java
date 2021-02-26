package com.jg.axon.aggregates;

import com.jg.axon.events.command.subject.CreateSubjectCommand;
import com.jg.axon.events.command.subject.DeleteSubjectCommand;
import com.jg.axon.events.command.subject.UpdateSubjectCommand;
import com.jg.axon.events.event.subject.SubjectCreatedEvent;
import com.jg.axon.events.event.subject.SubjectDeletedEvent;
import com.jg.axon.events.event.subject.SubjectUpdatedEvent;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Slf4j
@Aggregate
@NoArgsConstructor
public class SubjectAggregate {

    @AggregateIdentifier
    private UUID id;
    private String subjectName;

    // Create

    @CommandHandler
    public SubjectAggregate(final CreateSubjectCommand command) {
        AggregateLifecycle.apply(SubjectCreatedEvent.builder()
                .id(UUID.randomUUID())
                .subjectName(command.getSubjectName())
                .build());
    }

    // Update

    @CommandHandler
    public void handle(final UpdateSubjectCommand command) {
        // Validate
        AggregateLifecycle.apply(SubjectUpdatedEvent.builder()
                .id(command.getId())
                .subjectName(command.getSubjectName())
                .build());
    }

    // Delete

    @CommandHandler
    public void handle(final DeleteSubjectCommand command) {
        AggregateLifecycle.apply(SubjectDeletedEvent.builder()
                .id(command.getId())
                .build());
    }

    @EventSourcingHandler
    public void on(final SubjectCreatedEvent event) {
        this.id = event.getId();
        this.subjectName = event.getSubjectName();
    }

    @EventSourcingHandler
    public void on(final SubjectUpdatedEvent event) {
        this.id = event.getId();
        this.subjectName = event.getSubjectName();
    }

    @EventSourcingHandler
    public void on(final SubjectDeletedEvent event) {
        this.id = event.getId();
    }
}
