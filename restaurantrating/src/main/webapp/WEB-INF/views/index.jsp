<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="ISO-8859-1">
<title>Restaurant Ratings</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>

	<form action="/" method="get" ></form>
<div class="container">
		<h1>GC Restaurant Ratings</h1>
		<table class="table">
			<tr>
				<th>Rating</th>
				<th>Name</th>
			</tr>
			
			<c:forEach var="i" items="${restaurant }">
			 <tr>
			 	<td>${i.rating }</td>
			 	<td>${i.name }</td>
			 	<td>
				  <a href="/restaurant/voteup?id=${ items.id }"
     				class="btn btn-light btn-sm">Vote Up</a> <a
					href="/restaurant/votedown?id=${ i.id }"
					class="btn btn-light btn-sm">Vote Down</a>
				</td>
			  </tr>
			</c:forEach>
		</table>
</div>		

</body>
</html>