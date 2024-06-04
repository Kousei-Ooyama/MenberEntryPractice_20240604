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
<%@taglib prefix="c" uri="jakarta.tags.core" %>
	<h1>会員情報登録演習</h1>
	<div class="box">
		<hr>
			<p>
				変更したい場合は、変更したい項目のフォームをクリックし、書き換えたのちボタンを押してください
			</p>
		<hr>
		<c:if test="${update_result == 'success'}">
			<hr>
				<p>
					登録情報の変更を確認しました。
				</p>
			<hr>
		</c:if>
		<form action="MemberUpdate.action" method="post">
			<table class="member_info_table">
				<tr>
					<th>名前</th>
					<td>
						性<span class="inputbox"><input type="text" name="last_name" class="textbox_small" value="${member.last_name }" required></span>　
						名<span class="inputbox"><input type="text" name="first_name" class="textbox_small" value="${member.first_name }" required></span>
					</td>
				</tr>
				<tr>
					<th>性別</th>
					<td>
						<input type="radio" name="gender" value="男" ${member.gender == "男"? "checked":""}>男
						<input type="radio" name="gender" value="女" ${member.gender == "女"? "checked":""}>女
					</td>
				</tr>
				<tr>
					<th>生年月日</th>
					<td>
						<input type="text" name="birth_year" class="textbox_small" value="${member.birth_year }" required> 年
						<input type="text" name="birth_month" class="textbox_small" value="${member.birth_month }"required> 月
						<input type="text" name="birth_day" class="textbox_small" value="${member.birth_day }"required> 日
					</td>
				</tr>
				<tr>
					<th>職業</th>
					<td>
						<%
							String[] list= {"医療・福祉","教育","技術・エンジニア",
									"IT・通信","金融","販売・サービス","クリエイティブ",
									"マスコミ・出版","製造・生産","運輸・物流","公務員・行政"};
							request.setAttribute("job_list",list);
						%>
						<span class="inputbox">
							<select name="job" required>
								<c:forEach var="job" items="${job_list }">
									<option value="${job }" ${member.job == job? "selected": ""}>${job }</option>
								</c:forEach>
							</select>
						</span>
					</td>
				</tr>			<tr>
					<th>電話番号</th>
					<td><input type="text" name="phone_number" class="textbox" value="${member.phone_number }"required></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><input type="text" name="mail_address" class="textbox" value="${member.mail_address }"required></td>
				</tr>
			</table>
			<div class="formbox">
				<input type="submit" name="update_buttom" value="変更" class="submit">
				<input type="submit" name="return_buttom" value="もどる" class="submit">				
			</div>
			
		</form>	
	</div>
</body>
<script>
	"use strict";
	
	const update_result ="${update_result}";
	
	if(update_result === ""){
		//一回目なので何も表示しない
	}else if(update_result === "format-int-error"){
		window.alert("生年月日の項目には数字のみご入力ください");
	}else if(update_result==="phone_number-noint-error"){
		window.alert("電話番号の項目には数字のみご入力ください")
	}else if(update_result === "mail_address-no@-error"){
		window.alert("メールアドレスの項目には＠（ドメイン名）もご入力ください")
	}
	

	
</script>
</html>