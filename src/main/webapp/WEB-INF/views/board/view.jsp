<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<style>
		#list {
		  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
		  border-collapse: collapse;
		  width: 100%;
		}
		#list td, #list th {
		  border: 1px solid #ddd;
		  padding: 8px;
		  text-align:center;
		}
		#list tr:nth-child(even){background-color: #f2f2f2;}
		#list tr:hover {background-color: #ddd;}
		#list th {
		  padding-top: 12px;
		  padding-bottom: 12px;
		  text-align: center;
		  background-color: #006bb3;
		  color: white;
		}
		/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
	    .row.content {height: 1500px}
	    
	    /* Set gray background color and 100% height */
	    .sidenav {
	      background-color: #f1f1f1;
	      height: 100%;
	    }
	    
	    /* Set black background color, white text and some padding */
	    footer {
	      background-color: #555;
	      color: white;
	      padding: 15px;
	    }
	    
	    /* On small screens, set height to 'auto' for sidenav and grid */
	    @media screen and (max-width: 767px) {
	      .sidenav {
	        height: auto;
	        padding: 15px;
	      }
	      .row.content {height: auto;} 
	    }
	    
	    #addpost{
	    	background-color: 
	    }
	</style>
</head>
<body>
	<div class="alert alert-warning alert-dismissible fade in" role="alert">
	    <strong>Hello!</strong> Welcome to my blog!
	    <a href="#" class="close" data-dismiss="alert" aria-label="close" data-toggle="tooltip" title="Close this alert">&times;</a>
	</div>
	<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Personal Blog</h4>
      <ul class="nav nav-pills nav-stacked">
        <li><a href="../board/list">Home</a></li>
        <li><a href="../board/life">Life</a></li>
        <li><a href="../board/study">Study</a></li>
        <li><a href="../board/travel">Travel</a></li><br><br>
        <button onclick="location.href='add'" id="addpost">새글쓰기</button><button onclick="location.href='../login/logout'" id="logout">Logout</a>
      </ul><br>
    </div>

    <div class="col-sm-9">
      <h4><small>RECENT POSTS</small></h4>
		<jsp:include page="list.jsp" />
    </div>
  </div>
</div>
</body>
</html>