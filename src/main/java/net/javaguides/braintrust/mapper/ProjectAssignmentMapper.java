package net.javaguides.braintrust.mapper;

import net.javaguides.braintrust.dto.ProjectAssignmentDto;
import net.javaguides.braintrust.entity.ProjectAssignment;
import org.springframework.stereotype.Component;

@Component
public class ProjectAssignmentMapper {

    public ProjectAssignmentDto projectAssignDto(ProjectAssignment projectAssignment) {
        if (projectAssignment == null) return null;

        ProjectAssignmentDto projectAssignmentDto = new ProjectAssignmentDto();
        projectAssignmentDto.setId(projectAssignment.getId());
        projectAssignmentDto.setProjectAssignmentName(projectAssignment.getProjectAssignmentName());
        projectAssignmentDto.setDate(projectAssignment.getDate());

        return projectAssignmentDto;

    }

    public ProjectAssignment projectAssignment(ProjectAssignmentDto dto) {
        if (dto == null) return null;

        ProjectAssignment entity = new ProjectAssignment();
        entity.setId(dto.getId());
        entity.setProjectAssignmentName(dto.getProjectAssignmentName());
        entity.setDate(dto.getDate());
        return entity;
    }
}
