package com.jg.axon.events.event.student;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class StudentUpdatedEvent implements Serializable {

    private static final long serialVersionUID = 8875318004880969748L;

    private UUID id;
    private String firstName;
    private String lastName;
    private Set<UUID> subjectIds;

}
