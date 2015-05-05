<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exception page</title>
</head>
<body>
	<table width="960px" height="600px" border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td><jsp:include page="head.jsp" /></td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><font size="6" color="red">Exception occurred:</font></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="10"></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr height="80%" valign="top">
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><font size="5" color="red">${expMessage}</font></td>
					</tr>
					<tr>
						<td height="50"></td>
					</tr>
					<tr>
						<td><a href="javascript:history.go(-1);">Back</a></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td><jsp:include page="foot.jsp" /></td>
		</tr>
	</table>
</body>
</html>