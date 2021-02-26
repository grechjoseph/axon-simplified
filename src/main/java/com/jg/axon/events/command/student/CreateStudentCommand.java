package com.jg.axon.events.command.student;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class CreateStudentCommand implements Serializable {

    private static final long serialVersionUID = -8799129807551983344L;
    
    @Builder.Default
    @TargetAggregateIdentifier
    private UUID id = UUID.randomUUID();
    
    private String firstName;
    private String lastName;
    private Set<UUID> subjectIds;
    
}
