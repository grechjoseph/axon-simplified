package com.jg.axon.events.query.student;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class FindStudentsQuery implements Serializable {

    private static final long serialVersionUID = -6239550927805408243L;

    private UUID id;
    private String firstName;
    private String lastName;
    private Set<UUID> subjectIds;

}
