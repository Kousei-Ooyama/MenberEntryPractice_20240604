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
		<form action="MemberEntry.action" method="post">
			<h2>▶ログイン情報</h2>
			<div class="formbox">
				<p>■ログイン名<br>
				<span class="inputbox"><input type="text" name="login_name" class="textbox" required></span></p>
				<p>■パスワード<br>
				<span class="inputbox"><input type="password" name="password" class="textbox" required></span></p>
				<p>■再度パスワード<br>
				<span class="inputbox"><input type="password" name="password_again" class="textbox"required></span></p>
			</div>
			
			<hr>
			<h2>▶お客様情報</h2>
			<div class="formbox">
				<p>■名前<br>
					<span class="inputbox">
						姓<input type="text" name="last_name" class="textbox_small" required>　
						名<input type="text" name="first_name" class="textbox_small" required>				
					</span>
				</p>
				<p>■性別<br> 
					<span class="inputbox"> 
						<input type="radio"name="gender" value="男" checked>男
						<input type="radio" name="gender" value="女">女
					</span>
				</p>
				<p>■生年月日<br>
					<span class="inputbox">
						<input type="text" name="birth_year" class="textbox_small" required> 年
						<input type="text" name="birth_month" class="textbox_small" required> 月
						<input type="text" name="birth_day" class="textbox_small" required> 日
					</span>
				</p>
				<p>■電話番号　※ハイフンなし<br>
					<span class="inputbox">
						<input type="text" name="phone_number" class="textbox" required>
					</span>
				</p>
				<p>■メールアドレス　※ドメイン名までお願いします。<br>
					<span class="inputbox">
						<input type="text" name="mail_address" class="textbox" required>
					</span>
				</p>
				<p>■職業<br>
					<span class="inputbox">
						<select name="job" required>
							<option value="" selected>-- 選択してください --</option>
							<option value="医療・福祉">医療・福祉</option>
							<option value="教育">教育</option>
							<option value="技術・エンジニア">技術・エンジニア</option>
							<option value="IT・通信">IT・通信</option>
							<option value="金融">金融</option>
							<option value="販売・サービス">販売・サービス</option>
							<option value="クリエイティブ">クリエイティブ</option>
							<option value="マスコミ・出版">マスコミ・出版</option>
							<option value="建設・不動産">製造・生産</option>
							<option value="運輸・物流">運輸・物流</option>
							<option value="公務員・行政">公務員・行政</option>
						</select>
					</span>
				</p>
			</div>
			<div class="formbox">
				<input type="submit" name="entry_button" value="登録" class="submit">
				<input type="submit" name="reset_button" value="リセット" class="submit">
				<input type="submit" name="return_bottn" value="戻る" class="submit">
			</div>
		</form>
	</div>
	
</body>
<script>
	"use strict";
	
	const entry_result ="${entry_result}";
	
	if(entry_result === ""){
		//一回目なので何も表示しない
	}else if(entry_result === "login_name-error"){
		window.alert("同じ名前が存在するため登録できません。再度登録しなおしてください。");
	}else if(entry_result === "password-error"){
		window.alert("２つのパスワードに違いがあるため登録できませんでした。再度登録しなおしてください。");
	}else if(entry_result === "format-int-error"){
		window.alert("生年月日の項目には数字のみご入力ください");
	}else if(entry_result==="phone_number-noint-error"){
		window.alert("電話番号の項目には数字のみご入力ください")
	}else if(entry_result === "mail_address-no@-error"){
		window.alert("メールアドレスの項目には＠（ドメイン名）もご入力ください")
	}
	

	
</script>
</html>