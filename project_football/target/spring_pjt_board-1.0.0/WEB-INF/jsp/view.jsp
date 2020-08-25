<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>${view.bId}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${view.bName}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${view.bTitle}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${view.bContent}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${view.bHit}</td>
		</tr>
		<tr>
			<td colspan="5"><a href="list.do">목록</a><a href="delete.do">삭제</a></td>
		</tr>
	</table>
</body>
</html>