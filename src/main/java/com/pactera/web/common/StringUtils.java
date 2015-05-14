package com.pactera.web.common;

public class StringUtils {

	public static Boolean isEmpty(String value) {
		Boolean isEmpty = Boolean.FALSE;
		if (value == null || value.trim().length() < 1) {
			isEmpty = Boolean.TRUE;
		}
		return isEmpty;
	}

}
