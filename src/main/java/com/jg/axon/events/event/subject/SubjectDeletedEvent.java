package com.jg.axon.events.event.subject;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class SubjectDeletedEvent implements Serializable {

    private static final long serialVersionUID = -5244883910722774976L;

    private UUID id;

}
