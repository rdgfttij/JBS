<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring HelloWord</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	function clickBtnA() {
		var formData = $('#frmJoin').serialize();
		$.ajax({
			cache : false,
			url : '<c:url value="/ajax_modify_member.do"/>',
			type : 'POST', 
			data : formData, 
			success : function(data) {
				if(data.code == 'true') {
					alert('사용자 정보 수정이 정상적으로 처리 되었습니다.');
				}
				else {
					alert('사용자 정보 수정 처리가 실패 했습니다.');
				}
			}, 
			error : function(xhr, status) {
				alert('네트워크 오류 : ' + xhr + ' : ' + status);
			}
        });
	}
</script>

</head>
<body>
	<form id="frmJoin">
		이름 : <input type="text" name="username" value="${mapUser.name}">
		<br>
		비밀번호 : <input type="password" name="pwd" value="${mapUser.pwd}">
		<br>
		<button type="button" id="btnA" onclick="clickBtnA()">AJAX 사용자 정보 수정</button>
	</form>
	<br>
	<form id="frmJoin2" action="proc_modify_member.do" method="post">
		이름 : <input type="text" name="username" value="${mapUser.name}">
		<br>
		비밀번호 : <input type="password" name="pwd" value="${mapUser.pwd}">
		<br>
		<button type="submit" id="btnA">POST 사용자 정보 수정</button>
	</form>
	<br>
	<form id="frmJoin3" action="proc_modify_member.do" method="get">
		이름 : <input type="text" name="username" value="${mapUser.name}">
		<br>
		비밀번호 : <input type="password" name="pwd" value="${mapUser.pwd}">
		<br>
		<button type="submit" id="btnA">GET 사용자 정보 수정</button>
	</form>
</body>
</html>