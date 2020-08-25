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
 	<c:forEach var="boardMap" items="${boardview}" varStatus="status">
	<table border="1" summary="상세보기">
           <caption>상세보기</caption>
           <colgroup>
               <col width="80" />
               <col width="80" />
               <col width="200" />
               <col width="100" />
               <col width="300" />
           </colgroup>  
           <thead>
               <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                    <th>등록 일시</th>
                   <!--  <th>조회수</th> -->
               </tr>
           </thead>
          
           <tbody>
           
               <tr>
                    <td>${boardMap.no}</td>
                    <td>${boardMap.title}</td>
                    <td>${boardMap.comment}</td>
                    <td>${boardMap.name}</td>
                    <td>${boardMap.wdate}</td>
                   <%--  <td>${boardMap.view_cnt}</td> --%>
               </tr>
           </tbody>
           <tfoot>
           
           </tfoot>
       </table>
<p>
<label for="title">글 제목</label>
<input type="text" id="title" name="title" value="${boardMap.title}"  />
</p>
<hr/><hr/><hr/>
           	<button type="button" onclick="location.href='board_list.do'">목록</button>
       			&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
       		<button type="button" onclick="location.href='board_delete?no=${boardMap.no}'">삭제(기능o)</button>
       	   	<!-- <button type="button" onclick="location.href='#'">수정(추가예정)</button> -->
         
         <button type="button" onclick="location.href='board_update?no=${boardMap.no}'">수정(추가예정)</button>
         </c:forEach>
</body>
</html>