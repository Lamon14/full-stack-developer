package net.javaguides.braintrust.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleAssignmentDto {
    private long id;
    private LocalDate assignmentDate;
}
