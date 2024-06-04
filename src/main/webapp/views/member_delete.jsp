<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<%@include file="menu.jsp" %>
	<h1>会員情報登録演習</h1>
	<div class="box">
		<hr>
			<p>
				こちらのページから${member.last_name} ${member.first_name }さんの会員情報、すべてを削除することができます。<br>
				本当に行いまか？
			</p>
			<form action="MemberDelete.action" method="post">
				<div class="formbox">
					<input type="submit" name="delete_buttom" value="削除" class="submit">
					<input type="submit" name="return_buttom" value="もどる" class="submit">				
				</div>
			</form>
		<hr>
	
	</div>
</body>
</html>