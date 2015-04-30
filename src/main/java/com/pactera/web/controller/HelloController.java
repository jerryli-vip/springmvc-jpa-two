package com.pactera.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	Logger log = Logger.getLogger(HelloController.class);

	@RequestMapping(value = "sayHello")
	public ModelAndView sayHello(String name) {
		final String METHOD_NAME = "sayHello";
		log.debug(METHOD_NAME + " begin");

		log.debug("name : " + name);

		ModelAndView mav = new ModelAndView("hello");

		if (!StringUtils.isEmpty(name)) {
			mav.addObject("hello", "Hello, " + name + "!");
		}

		// test

		log.debug(METHOD_NAME + " end");

		return mav;
	}
}
