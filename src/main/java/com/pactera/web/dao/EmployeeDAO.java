package com.pactera.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pactera.web.model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
