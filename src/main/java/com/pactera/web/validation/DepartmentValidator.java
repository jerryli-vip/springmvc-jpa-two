package com.pactera.web.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pactera.web.common.Pagination;
import com.pactera.web.common.StringUtils;
import com.pactera.web.model.Department;

@Component
public class DepartmentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Department.class.isAssignableFrom(clazz) || Pagination.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Department dept = (Department) target;
		final String deptName = dept.getDeptName();
		final String location = dept.getLocation();

		ValidationUtils.rejectIfEmpty(errors, "deptName", "dept.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "location", "location.empty");

		if (deptName != null && deptName.length() > 0 && StringUtils.isEmpty(deptName)) {
			errors.rejectValue("deptName", "dept.name.empty");
		}

		if (location != null && location.length() > 0 && StringUtils.isEmpty(location)) {
			errors.rejectValue("location", "location.empty");
		}
	}

}
