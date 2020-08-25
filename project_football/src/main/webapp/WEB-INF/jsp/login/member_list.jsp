<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member list</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>
<th>리스트출력</th><br><br><br/>
 
 	<table>
 		<tr>
 			<td>아이디</td>
 			<td>이름</td>
 	 		<td>비밀번호</td>
 	 		<td>이메일</td>
 	 	 	<td>등급</td>
 		</tr>
	<c:forEach var="userMap" items="${userList}" varStatus="status">
		<tr>
			<td>${userMap.id}</td>
			<td>${userMap.name}</td>
			<td>${userMap.pwd}</td>
			<td>${userMap.email}</td>
			<td>${userMap.regdt}</td>
		</tr>
	</c:forEach>
	</table>
<a href=login_form.do>로그인</a>
	
</body>
</html>