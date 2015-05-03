<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exception page</title>
</head>
<body>
	<font size="6" color="red">Exception occurred:</font><br>
	<font size="5" color="red">${expMessage}</font>
	<br>
	<br>
	<br>
	<a href="javascript:history.go(-1);">Back</a>
</body>
</html>