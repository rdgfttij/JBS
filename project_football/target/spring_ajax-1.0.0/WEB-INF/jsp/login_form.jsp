<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	function clickBtnA() {
		var formData = $('#frmJoin').serialize();
		$.ajax({
			cache : false,
			url : '<c:url value="/ajax_login.do"/>',
			type : 'POST', 
			data : formData, 
			success : function(data) {
				if(data.code == 'true') {
					alert('정보 일치.');
					location.href="index.jsp";
				}
				else {
					alert('정보 불일치.');
				}
			}, 
			error : function(xhr, status) {
				alert('네트워크 오류 : ' + xhr + ' : ' + status);
			}
        });
	}
</script>
<body>
	<form id="frmJoin">
		이름 : <input type="text" name="id">
		<br>
		비밀번호 : <input type="text" name="pwd">
		<br>
		<button type="button" id="btnA" onclick="clickBtnA()">확인</button>
	</form>
</body>
</html>