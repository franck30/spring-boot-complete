package com.franck.springbootcomplete.service;

import com.franck.springbootcomplete.entity.Department;
import com.franck.springbootcomplete.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

  @Autowired
  private DepartmentService departmentService;


  @MockBean
  private DepartmentRepository departmentRepository;

  @BeforeEach
  void setUp() {
    Department department =
            Department.builder()
            .departmentName("IT")
            .departmentAddress("France")
            .departmentCode("IT-06")
            .departmentId(1L)
            .build();


    Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
            .thenReturn(department);
  }

  @Test
  @DisplayName("Get Data based on valid Department Name")
  public void whenValidDepartmentName_thenDepartmentShouldFound() {

    String departmentName = "IT";
    Department departmentFound =
            departmentService.fetchDepartmentByName(departmentName);

    assertEquals(departmentName, departmentFound.getDepartmentName());
  }


}