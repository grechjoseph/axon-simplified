package com.jg.axon.events.event.student;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class StudentDeletedEvent implements Serializable {

    private static final long serialVersionUID = -8478978398041569392L;

    private UUID id;

}
