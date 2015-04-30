package com.pactera.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseController {

	@ExceptionHandler
	public String exception(HttpServletRequest request, Exception e) {

		// exception handle, record log...
		request.setAttribute("expMessage", e.getMessage());

		return "exception";
	}
}
