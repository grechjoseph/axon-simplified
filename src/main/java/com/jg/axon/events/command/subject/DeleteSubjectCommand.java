package com.jg.axon.events.command.subject;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class DeleteSubjectCommand implements Serializable {

    private static final long serialVersionUID = 3682200387865531352L;

    @TargetAggregateIdentifier
    private UUID id;

}
