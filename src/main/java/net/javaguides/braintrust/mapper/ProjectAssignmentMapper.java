package net.javaguides.braintrust.mapper;

import net.javaguides.braintrust.dto.ProjectAssignmentDTO;
import net.javaguides.braintrust.entity.ProjectAssignment;
import org.springframework.stereotype.Component;

@Component
public class ProjectAssignmentMapper {

    public static ProjectAssignmentDTO toDTO(ProjectAssignment entity) {
        if (entity == null) return null;

        return new ProjectAssignmentDTO(
                entity.getId(),
                entity.getProjectAssignmentName(),
                entity.getDate()
        );
    }

    public static ProjectAssignment toEntity(ProjectAssignmentDTO dto) {
        if (dto == null) return null;

        ProjectAssignment entity = new ProjectAssignment();
        entity.setId(dto.getId());
        entity.setProjectAssignmentName(dto.getProjectAssignmentName());
        entity.setDate(dto.getDate());
        return entity;
    }
}
