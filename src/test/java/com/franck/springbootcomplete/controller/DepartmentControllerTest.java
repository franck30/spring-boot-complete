package com.franck.springbootcomplete.controller;

import com.franck.springbootcomplete.entity.Department;
import com.franck.springbootcomplete.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {


  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private DepartmentService departmentService;

  private Department department;

  @BeforeEach
  void setUp() {
    department = Department.builder()
            .departmentAddress("douala")
            .departmentCode("IT-098")
            .departmentName("IT")
            .departmentId(1L)
            .build();
  }

  @Test
  void saveDepartment() throws Exception {
    Department inputDepartment = Department.builder()
            .departmentAddress("douala")
            .departmentCode("IT-098")
            .departmentName("IT")
            .departmentId(1L)
            .build();

    Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

    mockMvc.perform(MockMvcRequestBuilders.post("/departments")
    .contentType(MediaType.APPLICATION_JSON)
    .content("{\n" +
            "\t\"departmentName\":\"I\",\n" +
            "\t\"departmentAddress\":\"douala\",\n" +
            "\t\"departmentCode\":\"IT-098\"\n" +
            "}")

    ).andExpect(MockMvcResultMatchers.status().isCreated());

  }

  @Test
  void fetchDepartmentById() {
  }
}