<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<title>DB接続</title>
</head>
<body>
	<h1>DBアクセス</h1>
	<hr>
	<h2>データ一覧</h2>
	<table class="select">
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>写真</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.id }</td>
				<td>${list.name}</td>
				<td><img src="/image/${list.picture}" />${list.picture}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>