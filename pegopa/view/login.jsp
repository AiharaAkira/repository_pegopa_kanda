<%@page import="bean.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>


<header
	style="width: 900px; display: flex; justify-content: center; align-items: center; margin: 50px auto 0 auto;">
	<img src="img/logo.png" alt="logo" width="70" height="70">
	<h1 style="padding-top: 20px; margin-left: 12px; color: hotpink;">
		<span style="font-size: 0.8em; color: gray;">株式会社</span>神田ユニフォーム
	</h1>
</header>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>


<body>
	<hr size="8" color="LightPink" width="90%"></hr>
	<h2 style="padding-top: 20px; text-align: center; color: gray;">ログイン</h2>

	<form action="<%=request.getContextPath()%>/login" method="post"
		onsubmit="return call();">

		<p style="text-align: center; color: gray; font-weight: 900;">
			ユーザーID：<input id="name" placeholder="メールアドレス"
				style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none; padding: 2px 4px;"
				type="email" name="name">
		</p>
		<p style="text-align: center; color: gray; font-weight: 900;">
			パスワード：<input id="pw" placeholder="パスワードを入力してください。"
				style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none; padding: 2px 4px;"
				type="password" name="pw">
		</p>
		<p style="text-align: center; color: gray; font-weight: 900;">
			<input class="button" id="l_btn"
				style="margin-top: 50px; background: none; border-radius: 8px; border: 3px solid pink; padding: 2px 6px; font-weight: 900; color: gray;"
				type="submit" value="ログイン">
		</p>



		<h4 style="text-align: center;"><%=request.getAttribute("cmd")%></h4>

	</form>

	<br>
	<br>

	<p align="center">
		<a style="color: gray;"
			href="<%=request.getContextPath()%>/accountInsert">新規会員登録はこちら</a>
	</p>
	<p align="center">
		<a style="color: grey;"
			href="<%=request.getContextPath()%>/uniformList">会員登録をせずに購入する</a>
	</p>

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

		function equalCheck(input1, input2) {
			if (input1.value != input2.value) {
				return true;
			}
			return false;
		}

		let u_id = document.getElementById('name');
		let u_pw = document.getElementById('pw');

		function call() {

			if (isEmpty(u_id)) {
				alert("ユーザーIDを入力してください。");
				u_id.value = "";
				u_id.focus();
				return false;
			}

			if (isEmpty(u_pw)) {
				alert("パスワードを入力してください。");
				u_pw.value = "";
				u_pw.focus();
				return false;
			}

			if (cnt == 1) {
				return false;
			}

			return true;

		}
	</script>

</body>

</html>