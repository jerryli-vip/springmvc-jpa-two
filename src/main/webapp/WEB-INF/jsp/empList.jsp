<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee List</title>
<script>
function deleteEmp(empno) {
	if(window.confirm("Are you sure to delete this object?")){
		var form = document.getElementById("empListForm");
		form.action = "delete?empno="+empno;
		form.submit();
	}
}
</script>
</head>
<body>
	<form id="empListForm" method="post" action="">
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
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td width="90%"><font size="5">Employee List</font></td>
													<td width="10%"><a href="showCreate">New</a></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td height="10"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="1" cellpadding="0" cellspacing="0">
									<tr>
										<th width="10%">EMP NO</th>
										<th width="15%">EMP NAME</th>
										<th width="15%">GENDER</th>
										<th width="15%">HIRE DATE</th>
										<th width="15%">SALARY</th>
										<th width="15%">DEPARTMENT</th>
										<th width="15%">ACTION</th>
									</tr>
									
									<c:if test="${empList eq null}">
										<tr>
											<td colspan="7">No record found.</td>
										</tr>
									</c:if>
									
									<c:if test="${empList ne null}">
										<c:forEach var="emp" items="${empList}">
											<tr>
												<td>${emp.empno}</td>
												<td>${emp.empName}</td>
												<td>${emp.gender eq 'M' ? 'Male' : 'Female'}</td>
												<td>${emp.hireDateStr}</td>
												<td>${emp.salary}</td>
												<td>${emp.dept.deptName}</td>
												<td align="center">
													<a href="showEdit?empno=${emp.empno}">edit</a>
													/
													<a href="#" onclick="deleteEmp(${emp.empno})">delete</a>
												</td>
											</tr>
										</c:forEach>
									</c:if>
									<c:if test="${pagination.pageCount > 0}">
										<tr>
											<td colspan="7"><jsp:include page="pagination.jsp" /></td>
										</tr>
									</c:if>
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
	</form>
</body>
</html>