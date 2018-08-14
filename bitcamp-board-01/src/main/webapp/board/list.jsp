<%@page import="bitcamp.pms.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 리스트</title>
</head>
<body>
<h1>게시물 리스트</h1>
<p><a href='add'>새 게시물</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>제목</th><th>날짜</th>
</tr>
<c:forEach items="${list}" var="board">
<tr>
    <td>${board.no}</td>
    <td><a href='view?title=${board.title}'>${board.title}</a></td>
    <td>${board.createdDate}</td>
</tr>
</c:forEach>
</table>
</body>
</html>