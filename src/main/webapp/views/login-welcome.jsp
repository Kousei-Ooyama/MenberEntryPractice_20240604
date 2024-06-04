<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン演習</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
<%@include file="menu.jsp" %>
	<h1>会員情報登録演習</h1>
	<div class= "box">
		<hr>
		<p>
			ようこそ、${member.last_name } ${member.first_name }さん！<br>
			あなたの登録情報は以下のようになっています。
		</p>
		<hr>
		<table class="member_info_table">
			<tr>
				<th>会員番号</th>
				<td>${member.member_id }</td>
			</tr>
			<tr>
				<th>名前</th>
				<td>${member.last_name } ${member.first_name }</td>
			</tr>
			<tr>
				<th>性別</th>
				<td>${member.gender }</td>
			</tr>
			<tr>
				<th>生年月日</th>
				<td>${member.birth_year}年 ${member.birth_month }月 ${member.birth_day }日</td>
			</tr>
			<tr>
				<th>仕事</th>
				<td>${member.job }</td>
			</tr>			
			<tr>
				<th>電話番号</th>
				<td>${member.phone_number }</td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td>${member.mail_address }</td>
			</tr>
		</table>
		<p>会員情報の変更はこちら→<a href="member_update.jsp">会員情報の更新</a></p>
		<p>会員情報の削除はこちら→<a href="member_delete.jsp">会員情報の削除</a></p>	
	</div>

</body>
</html>