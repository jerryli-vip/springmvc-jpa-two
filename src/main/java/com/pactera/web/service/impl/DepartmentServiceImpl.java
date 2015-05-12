package com.pactera.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pactera.web.common.Pagination;
import com.pactera.web.dao.DepartmentDAO;
import com.pactera.web.exception.ServiceException;
import com.pactera.web.model.Department;
import com.pactera.web.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	Logger log = Logger.getLogger(DepartmentServiceImpl.class);

	@Resource
	DepartmentDAO dao;

	@Value("#{configProperties['page.size']}")
	private String pageSize;

	@Transactional(rollbackFor = ServiceException.class)
	public Department save(Department dept) throws ServiceException {
		final String METHOD_NAME = "save";

		log.debug(METHOD_NAME + " begin");

		Department obj;
		try {
			obj = dao.save(dept);
		} catch (Exception e) {
			log.error("Error when save", e);
			throw new ServiceException(e.getMessage());
		}

		log.debug(METHOD_NAME + " end");
		return obj;
	}

	@Transactional(rollbackFor = ServiceException.class)
	public void delete(Integer deptno) throws ServiceException {
		final String METHOD_NAME = "delete";

		log.debug(METHOD_NAME + " begin");

		try {
			dao.delete(deptno);
		} catch (Exception e) {
			log.error("Error when delete by id : " + deptno, e);
			throw new ServiceException(e.getMessage());
		}

		log.debug(METHOD_NAME + " end");
	}

	public Department findById(Integer deptno) throws ServiceException {
		final String METHOD_NAME = "findById";
		log.debug(METHOD_NAME + " begin");
		log.debug(METHOD_NAME + " deptno : " + deptno);

		Department dept = null;
		try {
			dept = dao.getOne(deptno);
		} catch (Exception e) {
			log.error("Error when find by id : " + deptno, e);
			throw new ServiceException(e.getMessage());
		}

		log.debug(METHOD_NAME + " end");
		return dept;
	}

	public List<Department> findAll() throws ServiceException {
		final String METHOD_NAME = "findAll";
		log.debug(METHOD_NAME + " begin");

		List<Department> deptList = null;
		try {
			Sort sort = new Sort("deptName");
			deptList = dao.findAll(sort);

			log.debug(METHOD_NAME + " deptList.size : " + (CollectionUtils.isEmpty(deptList) ? 0 : deptList.size()));
		} catch (Exception e) {
			log.error("Error when find all", e);
			throw new ServiceException(e.getMessage());
		}

		log.debug(METHOD_NAME + " end");
		return deptList;
	}

	public List<Department> findAll(Pagination pagination) throws ServiceException {
		final String METHOD_NAME = "findAll";
		log.debug(METHOD_NAME + " begin");

		List<Department> deptList = null;
		try {
			// 1. no sort
			// deptList = dao.findAll();

			// 2. with sort
			Sort sort = new Sort("deptno");
			// deptList = dao.findAll(sort);

			// 3. pagination
			Integer pagesize = 0;
			try {
				pagesize = Integer.valueOf(pageSize);
				pagination.setPageSize(pagesize);
			} catch (Exception e) {
				log.info("Error when set page size", e);
			}
			pagination.setRecordCount(Integer.valueOf(String.valueOf(dao.count())));
			final int page = pagination.getPageNo() > 0 ? pagination.getPageNo() - 1 : 0;
			Pageable pageable = new PageRequest(page, pagination.getPageSize(), sort);
			Page<Department> pageRepo = dao.findAll(pageable);

			deptList = pageRepo.getContent();

			log.debug(METHOD_NAME + " deptList.size : " + (CollectionUtils.isEmpty(deptList) ? 0 : deptList.size()));
		} catch (Exception e) {
			log.error("Error when find all", e);
			throw new ServiceException(e.getMessage());
		}

		log.debug(METHOD_NAME + " end");
		return deptList;
	}
}
