package com.jg.axon.handler;

import com.jg.axon.data.model.Subject;
import com.jg.axon.data.service.SubjectDataService;
import com.jg.axon.events.event.subject.SubjectCreatedEvent;
import com.jg.axon.events.event.subject.SubjectDeletedEvent;
import com.jg.axon.events.event.subject.SubjectUpdatedEvent;
import com.jg.axon.events.query.subject.FindSubjectsQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectHandler {

    private final SubjectDataService subjectDataService;

    @EventHandler
    public void on(final SubjectCreatedEvent event) {
        subjectDataService.createSubject(Subject.builder()
                .id(event.getId())
                .subjectName(event.getSubjectName())
                .build());
    }

    @EventHandler
    public void on(final SubjectUpdatedEvent event) {
        subjectDataService.updateSubject(Subject.builder()
                .id(event.getId())
                .subjectName(event.getSubjectName())
                .build());
    }

    @EventHandler
    public void on(final SubjectDeletedEvent event) {
        subjectDataService.deleteSubject(event.getId());
    }

    @QueryHandler
    public List<Subject> handle(final FindSubjectsQuery query) {
        return Collections.singletonList(subjectDataService.getSubjectById(query.getId()));
    }
}
