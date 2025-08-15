package net.javaguides.braintrust.service.impl;

import net.javaguides.braintrust.dto.ProjectAssignmentDto;
import net.javaguides.braintrust.entity.ProjectAssignment;
import net.javaguides.braintrust.exceptionhandler.ResourceNotFoundException;
import net.javaguides.braintrust.mapper.ProjectAssignmentMapper;
import net.javaguides.braintrust.repository.ProjectAssignmentRepository;
import net.javaguides.braintrust.service.ProjectAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectAssignmentServiceImpl implements ProjectAssignmentService {

    private final ProjectAssignmentRepository projectAssignmentRepository;
    private final ProjectAssignmentMapper projectAssignmentMapper;

    public ProjectAssignmentServiceImpl(ProjectAssignmentRepository projectAssignmentRepository, ProjectAssignmentMapper projectAssignmentMapper) {
        this.projectAssignmentRepository = projectAssignmentRepository;
        this.projectAssignmentMapper = projectAssignmentMapper;
    }

    @Override
    public ProjectAssignmentDto create(ProjectAssignmentDto projectAssignmentDto) {
        ProjectAssignment projectAssignment = projectAssignmentMapper.projectAssignment(projectAssignmentDto);
        return projectAssignmentMapper.projectAssignDto(projectAssignmentRepository.save(projectAssignment));
    }

    @Override
    public ProjectAssignmentDto getProjectAssignmentsById(Long id) {
        ProjectAssignment projectAssignment = projectAssignmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProjectAssignment not found: " + id));
        return projectAssignmentMapper.projectAssignDto(projectAssignment);
    }

    @Override
    public List<ProjectAssignmentDto> getAllProjectAssignment() {
        List<ProjectAssignment> projectAssignments = projectAssignmentRepository.findAll();
        return projectAssignments.stream().map(projectAssignmentMapper::projectAssignDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectAssignmentDto update(Long id, ProjectAssignmentDto dto) {
        ProjectAssignment projectAssignment = projectAssignmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ProjectAssignment not found: " + id));

        projectAssignment.setProjectAssignmentName(dto.getProjectAssignmentName());
        projectAssignment.setDate(dto.getDate());

        return projectAssignmentMapper.projectAssignDto(projectAssignmentRepository.save(projectAssignment));
    }

    @Override
    public void deleteProjectAssignment(Long id) {

        projectAssignmentRepository.deleteById(id);
    }
}
