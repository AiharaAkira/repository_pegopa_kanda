<%@page import="bean.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Account a = (Account) session.getAttribute("accountList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更画面</title>



</head>
<body>



		<header
			style="width: 900px; display: flex; justify-content: center; align-items: center; margin: 50px auto 0 auto;">
			<img src="https://postfiles.pstatic.net/MjAyMzA2MjdfMjcy/MDAxNjg3ODMxMTk3NzMx.y2U6FThvXwdOi9XToRwE2N4H_hRXqdkBoCeK2m9852Mg.qxG3IdUM9aHf2hR4frt1B7kkSVwn5eb_OthgeJAIE04g.PNG.hyh3700/logo.png?type=w773" alt="logo" width="70" height="70">
			<h1 style="padding-top: 20px; margin-left: 12px; color: hotpink;">
				<span style="font-size: 0.8em; color: gray;">株式会社</span>神田ユニフォーム
			</h1>
		</header>
	<table align="left" style="padding-bottom: 5px; padding-left: 10%;">
		<tr>
			<td align="center"><a
				href="<%=request.getContextPath()%>/view/menu.jsp"
				style="text-decoration: none; color: gray; font-weight: 900;">【メニュー】</a></td>
		</tr>
	</table>
	<hr size="8" color="LightPink" width="90%"></hr>

	<h2 style="padding-top: 20px; text-align: center; color: gray;">会員情報変更</h2>
	<form method="post" onsubmit="return call();"
		action="<%=request.getContextPath()%>/accountUpdate"
		style="margin: 70px auto 200px auto; display: flex; flex-direction: column; align-items: center; justify-content: space-between; height: 180px;">
		<div
			style="display: flex; justify-content: space-between; width: 700px;">
			<table style="text-align: center; width: 500px; height: 50px">
				<tr>
					<td></td>
					<td style="text-align: center; color: hotpink; padding: 6;"><<変更前情報>></td>
				</tr>
				<tr>
					<td style="background-color: #C0C0C0; width: 110">氏名</td>
					<td style="width: 80"><%=a.getName()%></td>
				</tr>
				<tr>
					<td style="background-color: #C0C0C0;">住所</td>
					<td><%=a.getAddress()%></td>
				</tr>
				<tr>
					<td style="background-color: #C0C0C0;">ユーザーID</td>
					<td><%=a.getEmail()%></td>
				</tr>
				<tr>
					<td style="background-color: #C0C0C0;">パスワード</td>
					<td>英文字・数字・記号(8文字以上)</td>
				</tr>
				<tr>
					<td style="background-color: #C0C0C0;">パスワード確認</td>
					<td></td>
				</tr>

			</table>

			<table>
				<tr>
					<td style="text-align: center; color: hotpink; padding: 0;"><<変更後情報>></td>
				</tr>
				<tr>
					<td><input id="name" value="<%=a.getName()%>"
						style="border-radius: 12px; border: 3px solid pink; outline: none;"
						type=text size="25" name="name"></input></td>
				</tr>
				<tr>
					<td><input id="address" value="<%=a.getAddress()%>"
						style="border-radius: 12px; border: 3px solid pink; outline: none;"
						type=text size="25" name="address"></input></td>
				</tr>
				<tr>
					<td><input id="email" value="<%=a.getEmail()%>"
						style="border-radius: 12px; border: 3px solid pink; outline: none;"
						type=text size="25" placeholder="メールアドレス" name="email"></input></td>
				</tr>

				<tr>
					<td><input id="pw"
						style="border-radius: 12px; border: 3px solid pink; outline: none;"
						type="password" size="25" name="pw"></input></td>
				</tr>

				<tr>
					<td><input id="pwCheck"
						style="border-radius: 12px; border: 3px solid pink; outline: none;"
						type="password" size="25" name="pwCheck"></input></td>
				</tr>
			</table>
		</div>
		<h4 style="text-align: center;"><%=request.getAttribute("cmd")%></h4>
		<input type="hidden" name="id" value="<%=a.getId()%>"> <input
			style="margin-top: 90px; background: none; border: 3px solid pink; padding: 4px 6px; border-radius: 8px;"
			type="submit" value="変更完了">

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
			type = "." + type; //.jpg

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

		let u_name = document.getElementById('name');
		let u_address = document.getElementById('address');
		let u_email = document.getElementById('email');
		let u_pw = document.getElementById('pw');
		let u_pwCheck = document.getElementById('pwCheck');

		function call() {

			if (isEmpty(u_name) || lessThan(u_name, 2) || moreThan(u_name, 20)
					|| checkNum(u_name.value) || checkSpace(u_name.value)
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


			let result = confirm('変更しますか？');

			return result;

		}
	</script>
</body>
</html>