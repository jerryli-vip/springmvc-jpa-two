package com.pactera.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pactera.web.dao.DepartmentDAO;
import com.pactera.web.exception.SampleException;
import com.pactera.web.model.Department;
import com.pactera.web.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	Logger log = Logger.getLogger(DepartmentServiceImpl.class);

	@Resource
	DepartmentDAO departmentDAO;

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	@Transactional(rollbackFor = SampleException.class)
	public void save(Department dept) throws SampleException {
		final String METHOD_NAME = "save";

		log.debug(METHOD_NAME + " begin");

		departmentDAO.save(dept);

		log.debug(METHOD_NAME + " end");
	}

	@Transactional(rollbackFor = SampleException.class)
	public void delete(Department dept) throws SampleException {
		final String METHOD_NAME = "delete";

		log.debug(METHOD_NAME + " begin");

		departmentDAO.delete(dept);

		log.debug(METHOD_NAME + " end");
	}

	public Department findById(Integer deptno) throws SampleException {
		final String METHOD_NAME = "findById";
		log.debug(METHOD_NAME + " begin");
		log.debug(METHOD_NAME + " deptno : " + deptno);

		Department dept = departmentDAO.getOne(deptno);

		log.debug(METHOD_NAME + " dept = null : " + (dept == null));
		log.debug(METHOD_NAME + " end");
		return dept;
	}

	public List<Department> findAll() throws SampleException {
		final String METHOD_NAME = "findById";
		log.debug(METHOD_NAME + " begin");

		List<Department> deptList = departmentDAO.findAll();

		log.debug(METHOD_NAME + " deptList.size : " + (CollectionUtils.isEmpty(deptList) ? 0 : deptList.size()));
		log.debug(METHOD_NAME + " end");
		return deptList;
	}

}
