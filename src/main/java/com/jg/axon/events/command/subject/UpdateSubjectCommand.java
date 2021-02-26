package com.jg.axon.events.command.subject;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class UpdateSubjectCommand implements Serializable {

    private static final long serialVersionUID = 3612658753688396303L;

    @TargetAggregateIdentifier
    private UUID id;

    private String subjectName;
}
