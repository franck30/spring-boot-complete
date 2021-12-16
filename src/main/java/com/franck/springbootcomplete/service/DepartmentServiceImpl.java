package com.franck.springbootcomplete.service;


import com.franck.springbootcomplete.entity.Department;
import com.franck.springbootcomplete.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

  @Autowired
  private DepartmentRepository departmentRepository;


  @Override
  public Department saveDepartment(Department department) {
    return departmentRepository.save(department);
  }
}
