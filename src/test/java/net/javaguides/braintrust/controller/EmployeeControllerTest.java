package net.javaguides.braintrust.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.braintrust.dto.EmployeeDto;
import net.javaguides.braintrust.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.http.MediaType;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    private EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {
        employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setFirstName("John");
        employeeDto.setLastName("Smith");
        employeeDto.setEmail("john.smith@example.com");
        employeeDto.setMobileNumber("1234567890");
        employeeDto.setJobTitle("Developer");
        employeeDto.setSalary(50000.0);
        employeeDto.setHireDate(LocalDate.now());
    }

    @Test
    void createEmployee() throws Exception {
        when(employeeService.createEmployee(any(EmployeeDto.class))).thenReturn(employeeDto);

        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is("John")));
    }

    @Test
    void getEmployeeById() throws Exception {
        when(employeeService.getEmployeeById(1L)).thenReturn(employeeDto);

        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("John")));
    }

    @Test
    void testGetEmployeeById_NotFound() throws Exception {
        when(employeeService.getEmployeeById(99L)).thenReturn(null);

        mockMvc.perform(get("/api/employees/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllEmployees() throws Exception {
        List<EmployeeDto> employees = Collections.singletonList(employeeDto);
        when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(1)))
                .andExpect(jsonPath("$[0].firstName", is("John")));
    }

    @Test
    void deleteAccount() throws Exception {
        doNothing().when(employeeService).deleteEmployee(1L);

        mockMvc.perform(delete("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Account is deleted successfully!"));
    }

    @Test
    void updateEmployee() throws Exception {
        when(employeeService.updateEmployee(eq(1L), any(EmployeeDto.class))).thenReturn(employeeDto);

        mockMvc.perform(put("/api/employees/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("John")));
    }
}