<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/WEB-INF/include/header.jspf"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<div>
<ul  id="coreTopMenu">
<%-- <c:if test="${member == null}">
<span><a href='login_form.do'><font color="black"> 로그인 </font></a></span>&nbsp;&nbsp;
</c:if> --%>
<%-- <c:if test="${member != null }">
 	<p>${member}</p>
 	<a href='logout.do'>로그아웃</a>
</c:if> --%>

          <sec:authorize access="isAnonymous()">
          	<span><a href='<c:url value="login/LoginForm" />' class="badge badge-pill badge-info">LOGIN</a></span>
          </sec:authorize>
          
           <sec:authorize access="isAuthenticated()">
          	<form action="/spring_ajax/Logout" method="POST">
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		        <button type="submit" class="badge badge-pill badge-info">LOGOUT</button>
		    </form>
          </sec:authorize>
</ul>
</div>

