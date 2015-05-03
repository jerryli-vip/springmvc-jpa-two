package com.pactera.web.service;

import java.util.List;

import com.pactera.web.exception.SampleException;
import com.pactera.web.model.Department;

public interface DepartmentService {

	public void save(Department dept) throws SampleException;

	public void delete(Integer deptno) throws SampleException;

	public Department findById(Integer deptno) throws SampleException;

	public List<Department> findAll() throws SampleException;
}
