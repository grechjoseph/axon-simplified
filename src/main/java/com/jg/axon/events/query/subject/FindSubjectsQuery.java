package com.jg.axon.events.query.subject;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class FindSubjectsQuery implements Serializable {

    private static final long serialVersionUID = 6349028901662722722L;

    private UUID id;
    private String subjectName;

}
