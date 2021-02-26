package com.jg.axon.events.event.student;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class StudentCreatedEvent implements Serializable {

    private static final long serialVersionUID = -2518142523953376154L;

    private UUID id;
    private String firstName;
    private String lastName;
    private Set<UUID> subjectIds;

}
