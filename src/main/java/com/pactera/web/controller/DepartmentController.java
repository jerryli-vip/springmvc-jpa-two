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
public class DepartmentController extends BaseController {

	Logger log = Logger.getLogger(DepartmentController.class);

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "list")
	public ModelAndView list() throws Exception {
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

		mav = list();

		log.debug(METHOD_NAME + " end");
		return mav;
	}

	@RequestMapping(value = "showEdit")
	public ModelAndView showEdit(@RequestParam Integer deptno) throws Exception {
		final String METHOD_NAME = "showEdit";
		log.debug(METHOD_NAME + " begin");

		ModelAndView mav = new ModelAndView("deptEdit");

		Department dept = departmentService.findById(deptno);

		mav.addObject("dept", dept);

		log.debug(METHOD_NAME + " end");
		return mav;
	}

	@RequestMapping(value = "edit")
	public ModelAndView edit(@RequestParam String deptName, String location) throws Exception {
		final String METHOD_NAME = "edit";
		log.debug(METHOD_NAME + " begin");

		ModelAndView mav = null;
		Department dept = new Department();
		dept.setDeptName(deptName);
		dept.setLoc(location);
		departmentService.save(dept);

		mav = list();

		log.debug(METHOD_NAME + " end");
		return mav;
	}

	@RequestMapping(value = "delete")
	public ModelAndView delete(@RequestParam Integer deptno) throws Exception {
		final String METHOD_NAME = "delete";
		log.debug(METHOD_NAME + " begin");

		ModelAndView mav = null;

		departmentService.delete(deptno);

		mav = list();

		log.debug(METHOD_NAME + " end");
		return mav;
	}
}
