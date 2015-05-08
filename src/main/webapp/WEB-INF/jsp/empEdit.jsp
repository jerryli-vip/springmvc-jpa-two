<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Edit</title>
</head>
<body>
	<form:form commandName="employee" action="edit" method="POST">
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
										<td><font size="5">Employee Edit</font></td>
									</tr>
									<tr>
										<td height="10"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="140">Department</td>
										<td>
											<form:select path="dept.deptno">
												<form:option value="">Please select</form:option>
												<form:options items="${deptList}" itemLabel="deptName" itemValue="deptno"/>
											</form:select>
											&nbsp;<font color="red">*</font>&nbsp;
											<form:errors path="dept.deptno" cssStyle="color: red;" />
										</td>
									</tr>
									<tr height="10">
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>Employee No</td>
										<td>${employee.empno}
											<input type="hidden" name="empno" value="${employee.empno}">
										</td>
									</tr>
									<tr height="10">
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>Employee Name</td>
										<td>
											<form:input path="empName" value="${employee.empName}"/>&nbsp;<font color="red">*</font>&nbsp;
											<form:errors path="empName" cssStyle="color: red;" />
										</td>
									</tr>
									<tr height="10">
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>Gender</td>
										<td>
											<form:radiobutton path="gender" value="M"/>Male
											<form:radiobutton path="gender" value="F"/>Female
										</td>
									</tr>
									<tr height="10">
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>Hire Date</td>
										<td>
											<form:input path="hireDateStr" value="${employee.hireDateStr}" />&nbsp;(Formatter : yyyy-MM-dd)&nbsp;
											<font color="red">*</font>&nbsp;
											<form:errors path="hireDateStr" cssStyle="color: red;" />
										</td>
									</tr>
									<tr height="10">
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>Salary</td>
										<td>
											<form:input path="salary" value="${employee.salary}" />&nbsp;<font color="red">*</font>&nbsp;
											<form:errors path="salary" cssStyle="color: red;" />
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