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
	<hr>
	<h2>データ追加</h2>
	<form action="/insert" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="insertId" /></td>
			</tr>
			<tr>
				<td>名前</td>
				<td><input type="text" name="insertName" /></td>
			</tr>
			<tr>
				<td>写真</td>
				<td><input type="text" name="insertPicture" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="追加"></td>
			</tr>
		</table>
	</form>
	<hr>
	<h2>データ削除</h2>
	<form action="/delete" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="deleteId" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="削除"></td>
			</tr>
		</table>
	</form>
	<hr>
	<h2>データ更新</h2>
	<form action="/update" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="updateid" /></td>
			</tr>
			<tr>
				<td>名前</td>
				<td><input type="text" name="updateName" /></td>
			</tr>
			<tr>
				<td>写真</td>
				<td><input type="text" name="updatePicture" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="更新"></td>
			</tr>
		</table>
		</form>
</body>
</html>