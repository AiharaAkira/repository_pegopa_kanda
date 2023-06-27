<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユニフォーム情報登録</title>
	<header style=" width:900px; display: flex; justify-content: center; align-items: center; margin: 0 auto;">
			<img src="https://postfiles.pstatic.net/MjAyMzA2MjdfMjcy/MDAxNjg3ODMxMTk3NzMx.y2U6FThvXwdOi9XToRwE2N4H_hRXqdkBoCeK2m9852Mg.qxG3IdUM9aHf2hR4frt1B7kkSVwn5eb_OthgeJAIE04g.PNG.hyh3700/logo.png?type=w773" alt="logo" width="70" height="70">
				<h1 style="padding-top:20px; margin-left: 12px;">株式会社神田ユニフォーム</h1>
				<h1 style="padding-top:20px;"></h1>
		</header>
</head>
	<table align="left" style="padding-bottom:5px; padding-left:10%;">
	<tr>
		<td align="center"><a href="menu.jsp" style="text-decoration:none;">【メニュー】</a></td>
	</tr>
	</table>

	<body>
		<hr width="90%"></hr>
		<h2 style="padding-top:20px; text-align: center;">商品情報登録</h2>

	<form style="margin-top: 20px;" action = "<%=request.getContextPath()%>/uniformInsert" method="post" enctype="multipart/form-data" onsubmit="return call();">
		<table style="margin: 0 auto; border-spacing: 8px;">
			<tr>
				<th bgcolor="#66CC99" width="130">商品名</th>
				<td><input id="name" type=text name="name"></input></td>
			</tr>
			<tr>
				<th bgcolor="#66CC99" width="130">画像</th>
				<td><input id="file" type=file size="25" name="img"></input></td>
			</tr>
			<tr>
				<th bgcolor="#66CC99" width="130">単価</th>
				<td><input id="price" type=text name="price"></input></td>
			</tr>
			<tr>
				<th bgcolor="#66CC99" width="130">在庫数</th>
				<td><input id="stock" type="text" name="stock"></td>
			</tr>
			<tr>
				<td colspan=2 style="text-align: center;"><input style=" margin-top: 30px;  background: none; border-radius: 4px; border: 1px solid; padding: 2px 6px;" type="submit" value="登録"></td>
			</tr>
		</table>
	</form>





		<script type="text/javascript">
	function isEmpty(input) {

		return !input.value; //값이 없어서 거짓.

	}

	// <input>이랑 글자 수를 넣으면 그 글자수 보다 적으면 참, 아니면 거짓

	function lessThan(input, length) {

		return input.value.length < length;
	}

	function moreThan(input, length) {
		return input.value.length > length;
	}

	//인풋을 넣으면
	//한글/특수문자 들어있으면 참, 아니면 거짓

	function containKr(input) {
		// 엠지
		//input.value = 'q지';

		let ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890@._/";

		for (let i = 0; i < input.value.length; i++) {

			if (ok.indexOf(input.value[i]) == -1) {
				return true;

			}

		}
	}

	//input 데이터 2개 넣으면 내용이 다르면 true 아니면 false
	function equalData(input1, input2) {
		return !(input1.value == input2.value)
	}

	//<input> 문자열 세트
	// 그 문자열 세트가 포함 안되었으면 true
	// 들어있으면 false

	function notContains(input, set) {
		//input : 1qwerASD
		// set: 1234567890 숫자를 반드시 포함

		for (let i = 0; i < set.length; i++) {
			if (input.value.indexOf(set[i]) != -1)
				return false;
		}
		return true;
	}

	//체크박스 체크여부
	function notCheck(input) {
		if (input.checked) {
			return false;
		}
		return true;
	}

	//<input>을 넣어서
	// 숫자가 아니면 true, 숫자면 false
	function isNotNumber(input) {
		return isNaN(input.value);
	}

	//xxx(photoInput, "jpg")
	//그게 아니면 true, 아니면 false
	function isNotType(input, type) {
		type = "." + type; //.jpg

		return input.value.indexOf(type) == -1; //input에.jpg가 있나 없나
	}

	//특수문자 체크
	//if(pattern_spc.test(str))
	var pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자

	//실제로쓸때 input.value <<이렇게 써야됨
	// 한글 체크
	function checkKor(str) {
		const regExp = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;
		if (regExp.test(str)) {
			return true;
		} else {
			return false;
		}
	}

	// 숫자 체크
	function checkNum(str) {
		const regExp = /[0-9]/g;
		if (regExp.test(str)) {
			return true;
		} else {
			return false;
		}
	}

	// 영문(영어) 체크
	function checkEng(str) {
		const regExp = /[a-zA-Z]/g;
		// 영어
		if (regExp.test(str)) {
			return true;
		} else {
			return false;
		}
	}

	// 영문+숫자만 입력 체크
	function checkEngNum(str) {
		const regExp = /[a-zA-Z0-9]/g;
		if (regExp.test(str)) {
			return true;
		} else {
			return false;
		}
	}

	// 공백(스페이스 바) 체크
	function checkSpace(str) {
		if (str.search(/\s/) !== -1) {
			return true;
			// 스페이스가 있는 경우
		} else {
			return false; // 스페이스 없는 경우
		}
	}

	//아이디 체크
	function CheckID(uid) {

		if (!/^[a-zA-Z0-9]{8,20}$/.test(uid)) {
			alert("아이디는 숫자와 영문자 조합으로 8~20자리를 사용해야 합니다.");
			return true;
		}

		var chk_num = uid.search(/[0-9]/g);
		var chk_eng = uid.search(/[a-z]/ig);

		if (chk_num < 0 || chk_eng < 0) {
			alert("아이디는 숫자와 영문자를 혼용하여야 합니다.");
			return true;
		}
		if (/(\w)\1\1\1/.test(uid)) {
			alert("아이디에 같은 문자를 4번 이상 사용하실 수 없습니다.");
			return true;
		}

		return false;
	}

	//비밀번호체크
	function CheckPassword(upw) {
		/*if (!/^[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,20}$/.test(upw)) {
			alert("비밀번호는 숫자와 영문자 조합으로 8~20자리를 사용해야 합니다.");
			return true;
		}*/
		var chk_num = upw.search(/[0-9]/g);
		var chk_eng = upw.search(/[a-z]/ig);
		var chk_special = upw
				.search(/(?=.*[a-zA-ZS])(?=.*?[#?!@$%^&*-]).{8,20}/);
		if (chk_num < 0 || chk_eng < 0 || chk_special < 0) {
			alert("비밀번호는 숫자와 특수문자+영문자를 혼용하여야 합니다.");
			return true;
		}
		if (/(\w)\1\1\1/.test(upw)) {
			alert("비밀번호에 같은 문자를 4번 이상 사용하실 수 없습니다.");
			return true;
		}

		return false;
	}

	//윗값과 같은지 확인
	function equalCheck(input1, input2) {
		if (input1.value != input2.value) {
			return true;
		}
		return false;
	}

	let name = document.getElementById('name');
	let price = document.getElementById('price');
	let stock = document.getElementById('stock');
	let file = document.getElementById('file');

	function call() {

		if (isEmpty(name)) {
			alert("商品名を入力してください。");
			name.value = "";
			name.focus();
			return false;
		}

		if (isEmpty(price)) {
			alert("価格を入力してください。");
			price.value = "";
			price.focus();
			return false;
		}

		if (isEmpty(stock)) {
			alert("在庫数を入力してください。");
			stock.value = "";
			stock.focus();
			return false;
		}

		if (isNotNumber(price)){
			alert("数字を入力してください。");
			price.value = "";
			price.focus();
			return false;
		}

		if (isNotNumber(stock)){
			alert("数字を入力してください。");
			stock.value = "";
			stock.focus();
			return false;
		}


		if(!isEmpty(file)){
			if(isNotType(file, "jpg")&&isNotType(file, "png")){
				alert("ファイルの拡張子を確認してください。");
				return false;
			}

		}


		if (cnt == 1) {
			return false;
		}

		return true;

	}


</script>


	</body>


</html>