package com.jg.axon.data.service;

import com.jg.axon.data.model.Subject;
import com.jg.axon.data.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubjectDataService {

    private final SubjectRepository subjectRepository;

    public void createSubject(final Subject subject) {
        subjectRepository.save(subject);
    }

    public void updateSubject(final Subject subject) {
        subjectRepository.save(subject);
    }

    public void deleteSubject(final UUID subjectId) {
        subjectRepository.delete(getSubjectById(subjectId));
    }

    public Subject getSubjectById(final UUID subjectId) {
        return subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject with ID [" + subjectId +"] not found."));
    }

}
