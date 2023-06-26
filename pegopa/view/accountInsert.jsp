<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録画面</title>
<style type="text/css">
.heading-039 {
	display: flex;
	align-items: center;
	gap: 0 7px;
	color: #333333;
}

.heading-039::before {
	width: 1em;
	height: 1em;
	background-image:
		url('data:image/svg+xml;charset=utf8,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2024%2024%22%3E%20%3Cpath%20fill%3D%22%232589d0%22%20d%3D%22M13.6%2C4.4l6%2C6l-13%2C13L1.2%2C24c-0.7%2C0.1-1.3-0.5-1.2-1.2l0.6-5.4C0.6%2C17.4%2C13.6%2C4.4%2C13.6%2C4.4z%20M23.3%2C3.5l-2.8-2.8%20c-0.9-0.9-2.3-0.9-3.2%2C0l-2.7%2C2.7l6%2C6l2.7-2.7C24.2%2C5.8%2C24.2%2C4.4%2C23.3%2C3.5z%22%2F%3E%20%3C%2Fsvg%3E');
	content: '';
}
</style>

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
			<td align="center"><a
				href="<%=request.getContextPath()%>/logout"
				style="text-decoration: none; color: gray; font-weight: 900;">【ログイン】</a></td>
		</tr>
	</table>


	<hr size="8" color="LightPink" width="90%"></hr>

	<h2 style="text-align: center; color: gray; padding-top: 20px;">新規会員登録</h2>
	<form style="margin-top: 20px;"
		action="<%=request.getContextPath()%>/accountInsert" method="post"
		onsubmit="return call();">
		<table style="margin: 0 auto; border-spacing: 8px;">
			<tr>
				<th style="width: 80; color: gray;">ユーザーID</th>
				<td><input placeholder="email" id="email"
					style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;"
					type=email size="25" name="email"></input></td>

				<td>
					<h5 class="heading-039">メールアドレス</h5>
				</td>
			</tr>
			<tr>
				<th style="width: 80; color: gray;">氏名</th>
				<td><input id="name1"
					style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;"
					type=text size="25" name="name"></input></td>

			</tr>
			<tr>
				<th style="width: 80; color: gray;">パスワード</th>
				<td><input id="pw"
					style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;"
					type=password size="25" name="pw"></input></td>

				<td>
					<h5 class="heading-039">英文字・数字・記号(8文字以上)</h5>
				</td>
			</tr>
			<tr>
				<th style="width: 80; color: gray;">パスワード確認</th>
				<td><input
					style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;"
					type=password size="25" id="pwCheck" name="pwCheck"></input></td>
			</tr>
			<tr>
				<th style="width: 80; color: gray;">住所</th>
				<td><input
					style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;"
					type=text size="25" id="address" name="address"></input></td>


			</tr>
			<tr>
				<td colspan=3 style="text-align: center;"><input
					style="margin-top: 30px; background: none; border-radius: 8px; border: 3px solid pink; padding: 2px 6px; color: gray; font-weight: 900;"
					type="submit" value="登録"></td>
			</tr>
		</table>

		<h4 style="text-align: center;"><%=request.getAttribute("cmd")%></h4>

	</form>

	<script type="text/javascript">
		function isEmpty(input) {

			return !input.value;

		}


		function lessThan(input, length) {

			return input.value.length < length;
		}

		function moreThan(input, length) {
			return input.value.length > length;
		}


		function containKr(input) {

			let ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890@._/";

			for (let i = 0; i < input.value.length; i++) {

				if (ok.indexOf(input.value[i]) == -1) {
					return true;

				}

			}
		}

		function equalData(input1, input2) {
			return !(input1.value == input2.value)
		}


		function notContains(input, set) {

			for (let i = 0; i < set.length; i++) {
				if (input.value.indexOf(set[i]) != -1)
					return false;
			}
			return true;
		}

		function notCheck(input) {
			if (input.checked) {
				return false;
			}
			return true;
		}

		function isNotNumber(input) {
			return isNaN(input.value);
		}

		function isNotType(input, type) {
			type = "." + type;

			return input.value.indexOf(type) == -1;
		}

		var pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/;

		function checkKor(str) {
			const regExp = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;
			if (regExp.test(str)) {
				return true;
			} else {
				return false;
			}
		}

		function checkNum(str) {
			const regExp = /[0-9]/g;
			if (regExp.test(str)) {
				return true;
			} else {
				return false;
			}
		}

		function checkEng(str) {
			const regExp = /[a-zA-Z]/g;
			if (regExp.test(str)) {
				return true;
			} else {
				return false;
			}
		}

		function checkEngNum(str) {
			const regExp = /[a-zA-Z0-9]/g;
			if (regExp.test(str)) {
				return true;
			} else {
				return false;
			}
		}

		function checkSpace(str) {
			if (str.search(/\s/) !== -1) {
				return true;
			} else {
				return false;
			}
		}

		function CheckID(uid) {

			if (!/^[a-zA-Z0-9]{8,20}$/.test(uid)) {
				alert("ユーザーIDは8文字以上の英文字・数字・記号の組み合わせのみ入力できます。");
				return true;
			}

			var chk_num = uid.search(/[0-9]/g);
			var chk_eng = uid.search(/[a-z]/ig);

			if (chk_num < 0 || chk_eng < 0) {
				alert("ユーザーIDは小文字のみ入力できます。");
				return true;
			}
			if (/(\w)\1\1\1/.test(uid)) {
				alert("ユーザーIDは4回以上連続文字は入力できません。");
				return true;
			}

			return false;
		}

		function CheckPassword(upw) {

			var chk_num = upw.search(/[0-9]/g);
			var chk_eng = upw.search(/[a-z]/ig);
			var chk_special = upw
					.search(/(?=.*[a-zA-ZS])(?=.*?[#?!@$%^&*-]).{8,20}/);
			if (chk_num < 0 || chk_eng < 0 || chk_special < 0) {
				alert("8文字以上パスワードは英文字・数字・記号の組み合わせのみ入力できます。");
				return true;
			}
			if (/(\w)\1\1\1/.test(upw)) {
				alert("4回以上連続文字は入力できません。");
				return true;
			}

			return false;
		}

		function equalCheck(input1, input2) {
			if (input1.value != input2.value) {
				return true;
			}
			return false;
		}

		let u_email = document.getElementById('email');
		let u_name = document.getElementById('name1');
		let u_pw = document.getElementById('pw');
		let u_pwCheck = document.getElementById('pwCheck');
		let u_address = document.getElementById('address');

		function call() {

			if (isEmpty(u_email) || checkSpace(u_email.value)) {
				alert("ユーザーIDを確認してください。");
				u_email.value = "";
				u_email.focus();
				return false;
			}

			if (isEmpty(u_pw) || lessThan(u_pw, 8) || checkSpace(u_pw.value)
					|| checkKor(u_pw.value) || CheckPassword(u_pw.value)) {
				alert("パスワードを確認してください。");
				alert("パスワードは8文字以上の英文字・数字・記号の組み合わせのみ入力できます。");
				u_pw.value = "";
				u_pw.focus();
				return false;
			}
			if (equalCheck(u_pw, u_pwCheck)) {
				alert("パスワードを確認してください。");
				u_pwCheck.value = "";
				u_pwCheck.focus();
				return false;
			}

			if (isEmpty(u_name) || lessThan(u_name, 2) || moreThan(u_name, 20)
					|| checkNum(u_name) || checkSpace(u_name.value)
					|| (pattern_spc.test(u_name.value))) {
				alert("氏名を確認してください。");
				u_name.value = "";
				u_name.focus();
				return false;
			}

			if (isEmpty(u_address) || checkSpace(u_address.value)) {
				alert("住所を確認してください。");
				u_address.value = "";
				u_address.focus();
				return false;
			}

			let result = confirm('会員登録しますか？');

			return result;

		}
	</script>

</body>
</html>