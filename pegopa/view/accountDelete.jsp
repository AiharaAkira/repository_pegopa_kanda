<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員脱退</title>
</head>
<body>
	<header
		style="width: 900px; display: flex; justify-content: center; align-items: center; margin: 50px auto 0 auto;">
		<img src="logo.png" alt="logo" width="70" height="70">
		<h1 style="padding-top: 20px; margin-left: 12px; color: hotpink;">
			<span style="font-size: 0.8em; color: gray;">株式会社</span>神田ユニフォーム
		</h1>
	</header>
	<table align="left" style="padding-bottom: 5px; padding-left: 10%;">
		<tr>
			<td align="center"><a href="<%=request.getContextPath()%>/logout"
				style="text-decoration: none; color: gray; font-weight: 900;">【ログイン】</a></td>
		</tr>
	</table>


	<hr size="8" color="LightPink" width="90%"></hr>

	<h2 style="text-align: center; color: gray; padding-top: 20px;">会員脱退</h2>
	<form style="margin-top: 20px;"
		action="<%=request.getContextPath()%>/accountDelete" method="post"
		onsubmit="return call();">
		<table style="margin: 0 auto; border-spacing: 8px;">
			<tr>
				<th style="width: 80; color: gray;">氏名</th>
				<td><input
					style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;"
					type=text size="25" id="name1" name="name"></input></td>
			</tr>
			<tr>
				<th style="width: 80; color: gray;">パスワード</th>
				<td><input
					style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;"
					type=password size="25" id="pw" name="pw"></input></td>
			</tr>
			<tr>
				<th style="width: 80; color: gray;">メールアドレス</th>
				<td><input
					style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;"
					type=text size="25" id="email" name="email"></input></td>
			</tr>
			<tr>
				<td colspan=2 style="text-align: center;"><input
					style="margin-top: 30px; background: none; border-radius: 8px; border: 3px solid pink; padding: 2px 6px; color: gray; font-weight: 900;"
					type="submit" value="会員脱退"></td>
			</tr>
		</table>
	<h4 style="text-align: center;"><%=request.getAttribute("cmd")%></h4>
	</form>


	<script type="text/javascript">
		function isEmpty(input) {

			return !input.value;

		}

		function checkSpace(str) {
			if (str.search(/\s/) !== -1) {
				return true;
			} else {
				return false;
			}
		}

		let u_email = document.getElementById('email');
		let u_name = document.getElementById('name1');
		let u_pw = document.getElementById('pw');

		function call() {

			if (isEmpty(u_name) || checkSpace(u_name.value)) {
				alert("名前を確認してください。");
				u_name.value = "";
				u_name.focus();
				return false;
			}

			if (isEmpty(u_pw) || checkSpace(u_pw.value)) {
				alert("パスワードを確認してください。");
				u_pw.value = "";
				u_pw.focus();
				return false;
			}

			if (isEmpty(u_email) || checkSpace(u_email.value)) {
				alert("メールアドレスを確認してください。");
				u_email.value = "";
				u_email.focus();
				return false;
			}

			let result = confirm('削除しますか？');

			return result;

		}
	</script>

</body>
</html>