package com.jg.axon.events.event.subject;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class SubjectCreatedEvent implements Serializable {

    private static final long serialVersionUID = -5700788278580944644L;

    private UUID id;
    private String subjectName;

}
