<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강의 보기</title>
</head>
<body>
<h1>강의 보기</h1>
<c:choose>
<c:when test="${classroom == null}">
    <p>해당 강의가 존재하지 않습니다.</p>
</c:when>
<c:otherwise>
	<form action='update' method='post'>
	<table border='1'>
	<tr><th>번호</th><td>
	    <input type='text' name='crno' value='${classroom.crno}' readonly></td></tr>
	<tr><th>제목</th>
	    <td><input type='text' name='titl' value='${classroom.titl}'></td></tr>
	<tr><th>시작</th>
	    <td><input type='text' name='sdt' value='${classroom.sdt}'></td></tr>
	<tr><th>종료</th>
        <td><input type='text' name='edt' value='${classroom.edt}'></td></tr>
    <tr><th>교실</th>
        <td><input type='text' name='room' value='${classroom.room}'></td></tr>
	</table>
	<p>
	<a href='list'>목록</a>
	<button>변경</button>
	<a href='delete?crno=${classroom.crno}'>삭제</a>
	</p>
	</form>
</c:otherwise>
</c:choose>
</body>
</html>
    