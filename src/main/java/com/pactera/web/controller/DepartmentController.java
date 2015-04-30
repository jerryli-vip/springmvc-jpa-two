package com.pactera.web.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pactera.web.model.Department;
import com.pactera.web.service.DepartmentService;

@Controller
public class DepartmentController extends BaseController{

	Logger log = Logger.getLogger(DepartmentController.class);

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "list")
	public ModelAndView sayHello() throws Exception {
		final String METHOD_NAME = "list";
		log.debug(METHOD_NAME + " begin");

		ModelAndView mav = new ModelAndView("deptList");

		List<Department> deptList;
		deptList = departmentService.findAll();
		if (!CollectionUtils.isEmpty(deptList)) {
			mav.addObject("deptList", deptList);
		}

		log.debug(METHOD_NAME + " end");
		return mav;
	}

	@RequestMapping(value = "showCreate")
	public ModelAndView showCreate() throws Exception {
		final String METHOD_NAME = "showCreate";
		log.debug(METHOD_NAME + " begin");

		ModelAndView mav = new ModelAndView("deptNew");

		log.debug(METHOD_NAME + " end");
		return mav;
	}

	@RequestMapping(value = "create")
	public ModelAndView create(@RequestParam String deptName, String location) throws Exception {
		final String METHOD_NAME = "create";
		log.debug(METHOD_NAME + " begin");

		ModelAndView mav = null;
		Department dept = new Department();
		dept.setDeptName(deptName);
		dept.setLoc(location);
		departmentService.save(dept);

		mav = new ModelAndView("deptList");

		log.debug(METHOD_NAME + " end");
		return mav;
	}
}
