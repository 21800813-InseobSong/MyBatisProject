<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>새 글 쓰기</h1>
	<form action="addok" method="post" enctype="multipart/form-data">
		<table id="edit">
			<tr><td>제목</td><td><input type="text" name="title" /></td></tr>
			<tr><td>글쓴이</td><td><input type="text" name="writer" value="${login.username}" /></td></tr>
			<tr><td>카테고리</td><td><input type="radio" name="category" value="life" checked="checked" />Life <input type="radio" name="category" value="study" />Study <input type="radio" name="category" value="travel" />Travel</td></tr>
			<tr><td>내용</td><td><textarea cols="50" rows="5" name="content" /></textarea></td></tr>
			<tr><td>사진 업로드</td><td><input type="file" name="uploadFile"/></td></tr>
		</table>
		<button type="button" onclick="location.href='list'">목록보기</button>
		<button type="submit">등록하기</button>
	</form>
</body>
</html>