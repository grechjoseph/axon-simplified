package com.jg.axon.api;

import com.jg.axon.data.model.Subject;
import com.jg.axon.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public void createSubject(@RequestBody final Subject subject) {
        subjectService.createSubject(subject);
    }

    @PutMapping("/{subjectId}")
    public void updateSubject(@RequestBody final Subject subject, @PathVariable final UUID subjectId) {
        subjectService.updateSubject(Subject.builder()
                .id(subjectId)
                .subjectName(subject.getSubjectName())
                .build());
    }

    @DeleteMapping("/{subjectId}")
    public void deleteSubject(@PathVariable final UUID subjectId) {
        subjectService.deleteSubject(subjectId);
    }

    @GetMapping("/{subjectId}")
    public Subject getSubjectById(@PathVariable final UUID subjectId) {
        return subjectService.getSubjectById(subjectId);
    }

}
