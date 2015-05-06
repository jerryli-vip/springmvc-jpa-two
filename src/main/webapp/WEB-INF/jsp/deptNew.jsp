<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department New</title>
</head>
<body>
	<form:form commandName="department" action="create" method="POST">
		<input type="hidden" name="token" value="${token}" />
		<table width="960px" height="600px" border="0" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td><jsp:include page="head.jsp" /></td>
			</tr>
			<tr height="80%" valign="top">
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td><font size="5">Department Creation</font></td>
									</tr>
									<tr>
										<td height="10">
											<font color="green"><b>${message}</b></font>
											<font color="red"><b>${error}</b></font>&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="140">Department Name</td>
										<td>
											<form:input path="deptName" value="${department.deptName}"/>&nbsp;<font color="red">*</font>&nbsp;
											<form:errors path="deptName" cssStyle="color: red;" />
										</td>
									</tr>
									<tr height="10">
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>Location</td>
										<td>
											<form:input path="location" value="${department.location}" />&nbsp;<font color="red">*</font>&nbsp;
											<form:errors path="location" cssStyle="color: red;" />
										</td>
									</tr>
									<tr height="10">
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td><input type="submit" value="Save"></td>
										<td><input type="button" onclick="javascript:history.back();" value="Back"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><jsp:include page="foot.jsp" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>