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
        this.id = UUID.randomUUID();
        this.subjectName = command.getSubjectName();

        AggregateLifecycle.apply(SubjectCreatedEvent.builder()
                .id(this.id)
                .subjectName(command.getSubjectName())
                .build());
    }

    @EventSourcingHandler
    public void on(final SubjectCreatedEvent event) {
        this.subjectName = event.getSubjectName();
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

    @EventSourcingHandler
    public void on(final SubjectUpdatedEvent event) {
        this.subjectName = event.getSubjectName();
    }

    // Delete

    @CommandHandler
    public void handle(final DeleteSubjectCommand command) {
        AggregateLifecycle.apply(SubjectDeletedEvent.builder()
                .id(command.getId())
                .build());
    }

    @EventSourcingHandler
    public void on(final SubjectDeletedEvent event) {

    }
}
