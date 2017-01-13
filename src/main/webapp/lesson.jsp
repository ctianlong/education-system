<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程信息</title>
</head>
<body>

	<h2 align="center">课程信息查询</h2>
	
	<form action="${pageContext.request.contextPath }/lesson/query" method="post">
		<table align="center" cellpadding="10" cellspacing="0">
			<tr>
				<td>课程名称:</td>
				<td><input type="text" name="name" value="${lesson.name }"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="查询"/></td>
				<td><font color="red">${errorMsg }</font></td>
			</tr>
		</table>
	</form>
	
	<c:if test="${not empty result }">
		<table align="center" border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>课程名称</th>
				<th>课程编号</th>
				<th>授课教师</th>
				<th>选课人数</th>
				<th>上课地点</th>
				<th>开课季节</th>
				<th>上课时间</th>
				<th>备注</th>
			</tr>
			<c:forEach items="${result }" var="lesson">
				<tr>
					<td>${lesson.name }</td>
					<td>${lesson.lessonID }</td>
					<td>${lesson.teacher }</td>
					<td>${lesson.listener }</td>
					<td>${lesson.place }</td>
					<td>${lesson.season }</td>
					<td>${lesson.time }</td>
					<td>${lesson.note }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>