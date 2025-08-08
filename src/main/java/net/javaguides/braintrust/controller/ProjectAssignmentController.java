package net.javaguides.braintrust.controller;

import lombok.AllArgsConstructor;
import net.javaguides.braintrust.dto.ProjectAssignmentDto;
import net.javaguides.braintrust.exceptionhandler.ResourceNotFoundException;
import net.javaguides.braintrust.service.ProjectAssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/project-assignments")
public class ProjectAssignmentController {

    private ProjectAssignmentService projectAssignmentService;


    @PostMapping
    public ResponseEntity<ProjectAssignmentDto> createProjectAssignment(@RequestBody ProjectAssignmentDto projectAssignmentDto) {
        ProjectAssignmentDto saveProjectAssignment = projectAssignmentService.create(projectAssignmentDto);
        return new ResponseEntity<>(saveProjectAssignment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ProjectAssignmentDto> getAllProjectAssignments(@PathVariable("id") Long id) {
        ProjectAssignmentDto projectAssignmentDto = projectAssignmentService.getById(id);
        if (projectAssignmentDto == null) {
            throw new ResourceNotFoundException("ProjectAssignment is not found" + id);
        }
        return ResponseEntity.ok(projectAssignmentDto);
    }
}
