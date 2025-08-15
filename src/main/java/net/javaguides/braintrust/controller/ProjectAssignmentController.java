package net.javaguides.braintrust.controller;

import lombok.AllArgsConstructor;
import net.javaguides.braintrust.dto.ProjectAssignmentDto;
import net.javaguides.braintrust.exceptionhandler.ResourceNotFoundException;
import net.javaguides.braintrust.service.ProjectAssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<ProjectAssignmentDto> getProjectAssignmentsById(@PathVariable("id") Long id) {
        ProjectAssignmentDto projectAssignmentDto = projectAssignmentService.getProjectAssignmentsById(id);
        if (projectAssignmentDto == null) {
            throw new ResourceNotFoundException("ProjectAssignment is not found" + id);
        }
        return ResponseEntity.ok(projectAssignmentDto);
    }

    // Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<ProjectAssignmentDto>> getAllProjectAssignments(){
        List<ProjectAssignmentDto> projectAssignment = projectAssignmentService.getAllProjectAssignment();
        return ResponseEntity.ok(projectAssignment);
    }

    // Delete ProjectAssignment REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProjectAssignment(@PathVariable("id") Long id){
        projectAssignmentService.deleteProjectAssignment(id);
        return ResponseEntity.ok("ProjectAssignment is deleted successfully!");
    }
}
