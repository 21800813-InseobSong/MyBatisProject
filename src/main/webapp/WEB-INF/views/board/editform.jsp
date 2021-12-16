<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.my.mybatis.board.BoardDAO, com.my.mybatis.board.BoardVO" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>editform</title>
</head>
<body>
<h1>글 수정</h1>
<form:form commandName="boardVO" method="POST" action="../editok" enctype = "multipart/form-data">
		<form:hidden path="seq" />
		<input type="hidden" name="seq" />
		<table id="edit">
			<tr><td>제목</td><td><input type="text" name="title" /></td></tr>
			<tr><td>글쓴이</td><td><input type="text" name="writer" value="${login.username}" /></td></tr>
			<tr><td>카테고리</td><td><input type="radio" name="category" value="life" checked="checked" />Life <input type="radio" name="category" value="study" />Study <input type="radio" name="category" value="travel" />Travel</td></tr>
			<tr><td>내용</td><td><textarea cols="50" rows="5" name="content" /></textarea></td></tr>
			<tr><td>사진 업로드</td><td><input type="file" name="uploadFile"/></td></tr>
		</table>
		<button type="button" onclick="location.href='../list'">취소하기</button>
		<button type="submit">수정하기</button>
</form:form>
</body>
</html>