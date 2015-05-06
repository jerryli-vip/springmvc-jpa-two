package com.pactera.web.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pactera.web.common.Pagination;
import com.pactera.web.model.Department;

@Component
public class DepartmentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Department.class.isAssignableFrom(clazz) || Pagination.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "deptName", "dept.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "location", "location.empty");
	}

}
