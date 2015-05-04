<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department List</title>
<script>
function deleteDept(deptno) {
	if(window.confirm("Are you sure to delete this object?")){
		var form = document.getElementById("deptListForm");
		form.action = "delete?deptno="+deptno;
		form.submit();
	}
}
</script>
</head>
<body>
	<form id="deptListForm" method="post" action="">
		<table width="600" height="600" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td><jsp:include page="head.jsp" /></td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="90%"><font size="5">Department List</font></td>
							<td width="10%"><a href="showCreate">New</a></td>
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
					<table width="100%" border="1" cellpadding="0" cellspacing="0">
						<tr>
							<th width="20%">DEPT NO</th>
							<th width="30%">DEPT NAME</th>
							<th width="30%">LOCATION</th>
							<th width="20%">ACTION</th>
						</tr>
						
						<c:if test="${deptList eq null}">
						<tr>
							<td colspan="4">No record found.</td>
						</tr>
						</c:if>
						
						<c:if test="${deptList != null}">
							<c:forEach var="dept" items="${deptList}">
								<tr>
									<td>${dept.deptno}</td>
									<td>${dept.deptName}</td>
									<td>${dept.location}</td>
									<td align="center">
										<a href="showEdit?deptno=${dept.deptno}">edit</a>
										/
										<a href="#" onclick="deleteDept(${dept.deptno})">delete</a>
									</td>
								</tr>
							</c:forEach>
						</c:if>
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