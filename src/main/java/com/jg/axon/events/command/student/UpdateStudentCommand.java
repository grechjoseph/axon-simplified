package com.jg.axon.events.command.student;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class UpdateStudentCommand implements Serializable {

    private static final long serialVersionUID = -618407493655075863L;
    
    @TargetAggregateIdentifier
    private UUID id;
    
    private String firstName;
    private String lastName;
    private Set<UUID> subjectIds;
    
}
