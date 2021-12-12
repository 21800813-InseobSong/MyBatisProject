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
	<table id="list">
		<c:forEach items="${list}" var="u">
			<div class="container-fluid">
  				<div class="row content">
  					<div class="col-sm-9">
	  					<hr>
	  					<h2>${u.seq}</h2>
	     			 	<h2>${u.title}</h2>
					    <h5><span class="glyphicon glyphicon-time"></span> Post by ${u.writer}, ${u.regdate}. <span class="badge badge-primary">New</span> <a href="editform/${u.seq}">글수정</a> <a href="javascript:delete_ok('${u.seq}')">글삭제</a></h5>
					    <h5><span class="label label-danger">Category</span></h5><br>
					    <img src="DSC03298.jpg" height="500" width="750">
					    <p>${u.content}</p>
					    <br><br>
				    </div>
				 </div>
			</div>
		</c:forEach>
	</table>
	<br/><button type="button" onclick="location.href='add'">새글쓰기</button>
</body>
</html>