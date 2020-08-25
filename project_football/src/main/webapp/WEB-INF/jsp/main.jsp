<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/WEB-INF/include/header.jspf"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<style>
a{
text-decoration: none;
}
</style>
<body>
<header>
									
	<p  style="text-align: center; "><a href="main.do"> 					
	<font color="black" id="HOME"> main_page </font></a></p>
	<div style="text-align: right;">

	<jsp:include page="menu.jsp"/> 										
	</div>
	<hr>
	<br>
	<br>
</header>
<nav>
	<a href='BoardList'><font color="blue"> 게 시 판 </font></a><br><br><br/>
	<br><br><jsp:include page= "board/BoardList.jsp" /><br><br/>
</nav>
<section>
	<article>
	<div>
		<%-- <jsp:include page= "board/BoardList.jsp" /> --%>
		<%@include file="board/BoardList.jsp" %>
	</div>
	</article>
</section>
<footer>
	<address>
		주소: 서울특별시 구로구 xxx-xxx<br/>
		연락처 : 010 - xxx - xxx
	</address>
	<small>CopyLight &copy</small>
</footer>

</body>