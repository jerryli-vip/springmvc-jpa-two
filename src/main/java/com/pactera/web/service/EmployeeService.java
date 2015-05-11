package com.pactera.web.service;

import java.util.List;

import com.pactera.web.common.Pagination;
import com.pactera.web.exception.ServiceException;
import com.pactera.web.model.Employee;

public interface EmployeeService {

	public Employee save(Employee emp) throws ServiceException;

	public void delete(Integer deptno) throws ServiceException;

	public Employee findById(Integer empno) throws ServiceException;

	public List<Employee> findAll() throws ServiceException;

	public List<Employee> findAll(Pagination pagination) throws ServiceException;
}
