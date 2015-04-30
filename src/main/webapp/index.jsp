<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<table width="600" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="40%"><font size="6" color="green">Hello World!</font></td>
			<td width="40%">&nbsp;</td>
			<td width="10%"><a href="/springmvc-jpa">Home</a></td>
			<td width="10%"><a href="javascript:history.back();">Back</a></td>
		</tr>
		<tr>
			<td colspan="4" height="10"></td>
		</tr>
	</table>
	<table width="600" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="10%">1</td>
			<td><a href="sayHello?name=Jerry">sayHello</a></td>
		</tr>
		<tr height="10">
			<td colspan="2"></td>
		</tr>
		<tr>
			<td>2</td>
			<td><a href="list">department list</a></td>
		</tr>
		<tr height="10">
			<td colspan="2"></td>
		</tr>
	</table>
</body>
</html>
