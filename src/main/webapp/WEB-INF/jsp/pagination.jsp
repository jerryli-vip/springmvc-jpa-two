<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pagination</title>
<script type="text/javascript">
function goPage(){     
	window.location="${pageContext.request.contextPath}/${paginationURL}?pageNo=" + escape(document.getElementById('pageNo').value);
}
</script>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="10" colspan="14"></td>
		</tr>
		<tr>
			<td align="right">
				Current : ${pagination.pageNo}/${pagination.pageCount}
			</td>
			<td width="20">&nbsp;</td>
			<td width="30">
				<c:choose>
					<c:when test="${pagination.pageNo == 1 }">First</c:when>
					<c:otherwise><a href="${pageContext.request.contextPath}/${paginationURL}?pageNo=1">First</a></c:otherwise>
				</c:choose>
			</td>
			<td width="10">&nbsp;</td>
			<td width="50">
				<c:choose>
					<c:when test="${pagination.pageNo <= 1}">Previous</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/${paginationURL}?pageNo=${pagination.pageNo - 1 }">Previous</a>
					</c:otherwise>
				</c:choose>
			</td>
			<td width="10">&nbsp;</td>
			<td width="30">
				<c:choose>
					<c:when test="${pagination.pageNo >= pagination.pageCount}">Next</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/${paginationURL}?pageNo=${pagination.pageNo + 1}">Next</a>
					</c:otherwise>
				</c:choose>
			</td>
			<td width="10">&nbsp;</td>
			<td width="30">
				<c:choose>
					<c:when test="${pagination.pageNo == pagination.pageCount }">Tail</c:when>
					<c:otherwise><a href="${pageContext.request.contextPath}/${paginationURL}?pageNo=${pagination.pageCount}">Tail</a></c:otherwise>
				</c:choose>
			</td>
			<td width="20">&nbsp;</td>
			<td width="60" align="right">
				Go page
			</td>
			<td width="5">&nbsp;</td>
			<td width="40">
				<input type="text" id="pageNo" style="width:40px"/>
			</td>
			<td width="50" align="center">
				<input type="button" onclick="goPage()" value="Go"/>
			</td>
		</tr>
		<tr>
			<td height="5" colspan="14"></td>
		</tr>
	</table>
</body>
</html>