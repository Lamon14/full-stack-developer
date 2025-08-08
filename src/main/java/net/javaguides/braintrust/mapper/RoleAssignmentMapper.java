package net.javaguides.braintrust.mapper;

import net.javaguides.braintrust.dto.RoleAssignmentDto;
import net.javaguides.braintrust.entity.RoleAssignment;
import org.springframework.stereotype.Component;

@Component
public class RoleAssignmentMapper {

    public RoleAssignmentDto toDTO(RoleAssignment entity) {
        if (entity == null) return null;

        return new RoleAssignmentDto(
                entity.getId(),
                entity.getAssignmentDate()
        );
    }

    public RoleAssignment toEntity(RoleAssignmentDto dto) {
        if (dto == null) return null;

        RoleAssignment entity = new RoleAssignment();
        entity.setId(dto.getId());
        entity.setAssignmentDate(dto.getAssignmentDate());
        return entity;
    }
}
