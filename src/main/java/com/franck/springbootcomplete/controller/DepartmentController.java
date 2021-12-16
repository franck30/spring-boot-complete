package com.franck.springbootcomplete.controller;


import com.franck.springbootcomplete.entity.Department;
import com.franck.springbootcomplete.service.DepartmentService;
import com.franck.springbootcomplete.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @PostMapping("/departments")
  public Department saveDepartment(@RequestBody Department department) {

    return departmentService.saveDepartment(department);
  }


  @GetMapping("/departments")
  public List<Department> fetchDepartmentList() {
    return departmentService.fetchDepartmentList();
  }

}
