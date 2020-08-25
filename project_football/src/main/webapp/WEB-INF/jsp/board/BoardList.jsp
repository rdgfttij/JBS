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

<body>
	<table border="1" summary="게시판 목록">
           <caption>게시판 목록2</caption>
           <colgroup>
               <col width="50" />
               <col width="300" />
               <col width="80" />
               <col width="100" />
               <col width="70" />
           </colgroup>  
           <thead>
               <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>등록 일시</th>
                   <!--  <th>조회수</th> -->
               </tr>
           </thead>
           <tbody>
           <c:forEach var="boardMap" items="${boardList}" varStatus="status">
               <tr>
                    <td>${boardMap.no}</td>
                    <td><a href="boardview?no=${boardMap.no}">${boardMap.title}</a></td>
                    <td>${boardMap.name}</td>
                    <td>${boardMap.wdate}</td>
                   <%--  <td>${boardMap.view_cnt}</td> --%>
               </tr>
           </c:forEach>
           </tbody>
           <tfoot>
           </tfoot>
       </table>

  
       <p>
           <button type="button" onclick="location.href='board_write_form'">글 쓰 기</button>
       </p>
</body>
</html>