package com.jg.axon.events.command.subject;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class CreateSubjectCommand implements Serializable {

    private static final long serialVersionUID = 6663062111706007942L;

    @Builder.Default
    @TargetAggregateIdentifier
    private UUID id = UUID.randomUUID();

    private String subjectName;

}
