<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
</head>
<script>
	function delete_ok(id){
		var a = confirm("정말로 삭제하시겠습니까?");
		if(a)
			location.href="deleteok/" + id;
	}
</script>
<body>
	<h1>게시판</h1>
	<table id="list">
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Writer</th>
			<th>Regdate</th>
			<th>Content</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.seq}</td>
				<td>${u.title}</td>
				<td>Post by ${u.writer}</td>
				<td>${u.regdate}</td>
				<td>${u.content}</td>
				<td><a href="editform/${u.seq}">글수정</a></td>
				<td><a href="javascript:delete_ok('${u.seq}')">글삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/><button type="button" onclick="location.href='add'">새글쓰기</button>
</body>
</html>