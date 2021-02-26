package com.jg.axon.events.event.subject;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class SubjectUpdatedEvent implements Serializable {

    private static final long serialVersionUID = -2218035322893078778L;

    private UUID id;
    private String subjectName;

}
