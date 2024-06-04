<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="style.css" rel="stylesheet">
<%@taglib prefix="c" uri="jakarta.tags.core" %>
</head>
<body>
	<%@include file="menu.jsp" %>
	<h1>会員情報登録演習</h1>
	<c:if test="${member_deltet_success == 'success' }">
		<hr>
			<p>ログイン情報、及び会員情報を削除しました</p>
		<hr>
	</c:if>
	<p>IDとパスワードを入力してください</p>
	<form action="Login.action" method="post">
		ID：<input type="text" name="login_name" value="${login_name }" required><br>
		パスワード：<input type="password" name="password">
		<input type="submit" value="ログイン">
	</form>
	
	<p>会員登録が済んでいない方はこちら　<a href="member-entry.jsp">→新規会員登録</a></p>
</body>
<script>
	"use strict";

	const login_name="${login_name}";

	if(login_name === ""){
		//一回目なので何も表示しない
	}else{
		window.alert("IDもしくはパスワードが違います");
	}
	
</script>
</html>