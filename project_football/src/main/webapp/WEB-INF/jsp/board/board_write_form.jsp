<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<form id="frmJoin3" action="proc_insert_board.do" method="post">
		<td><b>게시글</b><br/></td>
		작성자 : <input type="text" name="name" ><br>
		제   목 : <input type="text" name="title"><br>
		내   용 : <textarea name="comment" cols="40" rows="8" ></textarea><br>
		<button type="submit">등록</button>
	</form>
</body>

</html>