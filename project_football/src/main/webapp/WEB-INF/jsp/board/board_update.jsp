<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 form</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> -->

<body>
<form action="board_modify" method="post">
 	<c:forEach var="boardMap" items="${boardview}" varStatus="status">
<p>
<label for="no">글 번호</label>
<input type="text" id="no" name="no" value="${boardMap.no}" Readonly="readonly"  />
</p>
<p>
<label for="title">글 제목</label>
<input type="text" id="title" name="title" value="${boardMap.title}"  />
</p>
<p>
<label for="comment">글 내용</label>
<textarea id="comment" name="comment">${boardMap.comment}</textarea>
</p>
<p>
<label for="name">작성자</label>
<input type="text" id="name" name="name" value="${boardMap.name}" Readonly="readonly"  />
</p>
<p>
<label for="wdate">작성일자</label>
<input type="text" id="wdate" name="wdate" value="${boardMap.wdate}" Readonly="readonly" />
</p>
 </c:forEach>
<hr/><hr/><hr/>

       		<button type="submit" ">수정</button>
       		<button>취소</button>
 </form>        
</body>
</html>