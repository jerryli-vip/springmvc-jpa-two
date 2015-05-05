package com.pactera.web.service;

import java.util.List;

import com.pactera.web.common.Pagination;
import com.pactera.web.exception.ServiceException;
import com.pactera.web.model.Department;

public interface DepartmentService {

	public void save(Department dept) throws ServiceException;
	
	public void update(Department dept) throws ServiceException;

	public void delete(Integer deptno) throws ServiceException;

	public Department findById(Integer deptno) throws ServiceException;

	public List<Department> findAll(Pagination pagination) throws ServiceException;
}
