<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/include/header.jspf"  %>
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>
  <br><br>
  <div class="container col-md-4">
	<form class="px-4 py-3" id="frmJoin" action="/spring_ajax/login" method="POST">
		<div class="form-group">
    		<label for="exampleDropdownFormID1">ID</label> 
    		<input type="text" class="form-control" name="id" id="id" placeholder="Login"/>
    	</div>
    	<div class="form-group">
    		<label for="exampleDropdownFormPassword1">ID</label>
    		<input type="password" class="form-control" name="pwd" id="pwd" placeholder="Password"/>
    	</div>
    	 <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	      		<font color="red">
	      			<p> 패스워드 오류<br/>
	      				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
	      			</p>
	      			<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
	      		</font>
	     </c:if>
    	 <div class="form-check">
	              <label class="form-check-label">
	              <input type="checkbox" class="form-check-input">
	              Remember me
	              </label>
	     </div>
    	 <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
   		 <!-- <button type="button" class="btn btn-primary" id="btnA" onclick="clickBtnA()">Sign in</button> -->
   		  <button type="submit" class="btn btn-primary" id="submit">Sign in</button>
	</form>
	 <div class="dropdown-divider"></div>
	      <a class="dropdown-item" href=login_join>New around here? Sign up</a>
	      <a class="dropdown-item" href="#">Forgot password?</a>
 </div>
</body>
</html>