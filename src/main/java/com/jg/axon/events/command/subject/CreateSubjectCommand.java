package com.jg.axon.events.command.subject;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CreateSubjectCommand implements Serializable {

    private static final long serialVersionUID = 6663062111706007942L;

    private String subjectName;

}
