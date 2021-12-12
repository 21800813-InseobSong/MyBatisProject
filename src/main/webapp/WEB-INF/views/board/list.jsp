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
  					<div class="col-sm-15">
	  					<hr>
	     			 	<h2>${u.title}</h2>
					    <h4><span class="glyphicon glyphicon-time"></span> Post by ${u.writer}, ${u.regdate}. <span class="badge badge-primary">New</span> <span class="label label-primary" onclick="location.href='editform/${u.seq}'">글수정</span> <span class="label label-danger" onclick="javascript:delete_ok('${u.seq}')">글삭제</span></h4>
					    <h4><span class="label label-info">${u.category}</span></h4><br>
					    <img src="${u.filename}" height="500" width="750">
					    <p>${u.content}</p>
				    </div>
				 </div>
			</div>
		</c:forEach>
	</table>
	<br/>
</body>
</html>