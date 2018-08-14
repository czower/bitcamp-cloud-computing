<%@page import="bitcamp.pms.domain.Classroom"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강의목록</title>
</head>
<body>
<h1>강의목록</h1>
<p><a href='form.html'>강의개설</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>제목</th><th>시작</th><th>종료</th><th>교실</th>
</tr>
<c:forEach items="${list}" var="classroom">
<tr>
    <td>${classroom.crno}</td>
    <td><a href='view?titl=${classroom.titl}'>${classroom.titl}<a></td>
    <td>${classroom.sdt}</td>
    <td>${classroom.edt}</td>
    <td>${classroom.room}</td>
</tr>
</c:forEach>
</table>
</body>
</html>