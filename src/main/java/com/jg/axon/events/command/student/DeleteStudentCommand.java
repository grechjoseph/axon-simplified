package com.jg.axon.events.command.student;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class DeleteStudentCommand implements Serializable {
    
    private static final long serialVersionUID = 7270977846883803169L;
    
    @TargetAggregateIdentifier
    private UUID id;
    
}
