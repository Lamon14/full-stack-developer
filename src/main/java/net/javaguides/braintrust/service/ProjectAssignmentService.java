package net.javaguides.braintrust.service;

import net.javaguides.braintrust.dto.ProjectAssignmentDto;

import java.util.List;

public interface ProjectAssignmentService {
    ProjectAssignmentDto create(ProjectAssignmentDto projectAssignmentDto);

    ProjectAssignmentDto getProjectAssignmentsById(Long id);

    List<ProjectAssignmentDto> getAllProjectAssignment();

    ProjectAssignmentDto update(Long id, ProjectAssignmentDto dto);

    void deleteProjectAssignment(Long id);
}
