package com.pactera.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController extends BaseController {

	Logger log = Logger.getLogger(HelloController.class);

	@RequestMapping(value = "hello")
	public ModelAndView hello() throws Exception {
		final String METHOD_NAME = "hello";
		log.debug(METHOD_NAME + " begin");

		ModelAndView mav = new ModelAndView("helloInput");

		log.debug(METHOD_NAME + " end");

		return mav;
	}

	@RequestMapping(value = "sayHello")
	public ModelAndView sayHello(String name) throws Exception {
		final String METHOD_NAME = "sayHello";
		log.debug(METHOD_NAME + " begin");

		log.debug("name : " + name);

		ModelAndView mav = new ModelAndView("hello");

		String value = null;
		if (!StringUtils.isEmpty(name)) {
			value = "Hi, " + name + "! Welcome to the Spring MVC world!";
		} else {
			value = "Hello, Jerry! Welcome to the Spring MVC world!";
		}
		mav.addObject("message", value);

		log.debug(METHOD_NAME + " end");

		return mav;
	}
}
