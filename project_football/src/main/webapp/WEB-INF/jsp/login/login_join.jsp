<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/include/header.jspf"  %>
<title>Insert title here</title>
</head>

<script>
	$(document).ready(function(){
		$("#submit").on("click", function(){
			if($("#id").val()==""){
				alert("아이디를 입력해주세요.");
				$("#id").focus();
				return false;
			}
			if($("#pwd").val()==""){
				alert("비밀번호를 입력해주세요.");
				$("#pwd").focus();
				return false;
			}
			if($("#name").val()==""){
				alert("성명을 입력해주세요.");
				$("#name").focus();
				return false;
			}
			if($("#email").val()==""){
				alert("이메일을 입력해주세요.");
				$("#email").focus();
				return false;
			}
				
			var idChkVal = $("#idChk").val();
			if(idChkVal == "N"){
				alert("아이디 중복확인 눌러주세요.");
			}else if(idChkVal =="Y"){
				$("#regForm").sumbit();
			}
		});	
	})
	
	function clickBtnA() {
		alert("1111111111111111111111111111");
		$.ajax({
			url : '<c:url value="/idChk" />',
			type : 'POST',
			dataType : 'json',
			data : {"id" : $("#id").val()},
			success : function(data){
				if(data == 1){
					alert("사용중인 아이디 입니다.");
				}else if(data == 0){
					$("#idChk").attr("value", "Y");
					alert("사용 가능한 아이디 입니다.");
				}
			}
		})
	}
</script>


<body>
	<br><br>
	<div class="container text-center">
		<h1>회원 가입</h1>
	</div>
	<div class="container col-md-4">
		<form class="px-4 py-3" action="proc_insert_member" method="POST" id="regForm">
			<div class="form-group">
				<label for="id">ID</label>
				<input type="text" class="form-control" name="id" id="id">
				<button type="button"  id="idChk" onclick="clickBtnA();" value="N">중복확인</button>
			</div>
			
			<div class="form-group">
				<label for="InputPW">PassWord</label>
				<input type="password" class="form-control" name="pwd" id="pwd">
			</div>
			
			<div class="form-group">
				<label for="InputName">이 름</label>
				<input type="text" class="form-control" name="name" id="name">
			</div>
			
			<div class="form-group">
				<label for="InputEmail">E-mail</label>
				<input type="text" class="form-control" name="email" id="email">
			</div>
			
			<div class="form-group text-center">
				<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
				<button id="submit" type="submit" class="btn btn-primary">회원가입<i class="fa fa-check spaceLeft"></i></button>
				<button onclick="location='redirect/login_from'" class="btn btn-warming" >가입취소<i class="fa fa-check spaceLeft"></i></button>
			</div>
		</form>
	</div>
</body>
</html>