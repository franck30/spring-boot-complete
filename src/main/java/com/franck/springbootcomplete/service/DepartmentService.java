package com.franck.springbootcomplete.service;

import com.franck.springbootcomplete.entity.Department;

import java.util.List;

public interface DepartmentService  {
  public Department saveDepartment(Department department);

  public List<Department> fetchDepartmentList();
}
