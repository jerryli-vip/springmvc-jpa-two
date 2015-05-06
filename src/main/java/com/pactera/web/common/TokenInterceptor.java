package com.pactera.web.common;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TokenInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Token annotation = method.getAnnotation(Token.class);
			if (annotation != null) {

				// 1. check save
				boolean needSaveSession = annotation.save();
				// for resubmit when error
				Object obj = request.getSession(false).getAttribute("reSubmitWhenError");
				Boolean reSubmitWhenError = obj == null ? Boolean.FALSE : Boolean.valueOf(obj.toString());
				if (reSubmitWhenError) {
					needSaveSession = true;
				}

				if (needSaveSession) {
					request.getSession(false).setAttribute("token", UUID.randomUUID().toString());
				}

				// 2. check remove
				boolean needRemoveSession = annotation.remove();
				// for resubmit when error
				if (reSubmitWhenError) {
					needRemoveSession = false;
				}

				if (needRemoveSession) {
					if (isRepeatSubmit(request)) {
						response.sendRedirect(request.getContextPath() + "/dept/list");
						return false;
					}
					request.getSession(false).removeAttribute("token");
				}

				// remove re-submit indicator
				if (obj != null) {
					request.getSession(false).removeAttribute("reSubmitWhenError");
				}
			}
			return true;
		} else {
			return super.preHandle(request, response, handler);
		}
	}

	private boolean isRepeatSubmit(HttpServletRequest request) {
		final String serverToken = (String) request.getSession(false).getAttribute("token");
		if (serverToken == null) {
			return true;
		}
		final String clinetToken = request.getParameter("token");
		if (clinetToken == null) {
			return true;
		}
		if (!serverToken.equals(clinetToken)) {
			return true;
		}
		return false;
	}
}
