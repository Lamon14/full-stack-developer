package net.javaguides.braintrust.service;

import net.javaguides.braintrust.dto.ProjectAssignmentDto;

import java.util.List;

public interface ProjectAssignmentService {
    ProjectAssignmentDto create(ProjectAssignmentDto projectAssignmentDto);

    ProjectAssignmentDto getById(Long id);

    List<ProjectAssignmentDto> getAll();

    ProjectAssignmentDto update(Long id, ProjectAssignmentDto dto);

    void delete(Long id);
}
