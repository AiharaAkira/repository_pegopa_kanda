<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.*, bean.Account, bean.Order"%>
<%Account a = (Account) session.getAttribute("accountList");
Order order = (Order)request.getAttribute("order");
DecimalFormat df = new DecimalFormat("###,###");
int stock = 1;
if(request.getAttribute("stock")!=null) {
	stock = (int)request.getAttribute("stock");
	}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文画面</title>
</head>
	<body>
			<header
			style="width: 900px; display: flex; justify-content: center; align-items: center; margin: 50px auto 0 auto;">
			<img src="https://postfiles.pstatic.net/MjAyMzA2MjdfMjcy/MDAxNjg3ODMxMTk3NzMx.y2U6FThvXwdOi9XToRwE2N4H_hRXqdkBoCeK2m9852Mg.qxG3IdUM9aHf2hR4frt1B7kkSVwn5eb_OthgeJAIE04g.PNG.hyh3700/logo.png?type=w773" alt="logo" width="70" height="70">
			<h1 style="padding-top: 20px; margin-left: 12px; color: hotpink;">
				<span style="font-size: 0.8em; color: gray;">株式会社</span>神田ユニフォーム
			</h1>
		</header>
			<table align="left" style="padding-bottom:5px; padding-left:10%;">
				<tr>
					<td align="center"><a href="<%=request.getContextPath()%>/view/menu.jsp" style="text-decoration:none; color: gray; font-weight: 900;">【メニュー】</a></td>
					<td align="center"><a href="<%=request.getContextPath() %>/uniformList" style="text-decoration:none; color: gray; font-weight: 900;">【商品一覧】</a></td>
				</tr>
			</table>
		<hr size="8" color="LightPink" width="90%"></hr>

<%if(stock== 0){ %>

	<h3 style="text-align: center; color: gray;">在庫が切れて購入できません。</h3>
	<div align = "center">
	<a style="display: inline-block; margin-top: 150px; border: 3px solid pink; border-radius: 8px; padding: 4px 8px; cursor: pointer; color: gray; font-weight: 900; text-decoration: none;" href = "view/menu.jsp">戻る</a>
	</div>
<%}else if(order==null){
	if(a == null) {%>
	<!-- 非会員の注文画面 -->
	<div align = "center">
			<h2  style="color: gray;">注文内容</h2>
			<form style="margin-top: 20px;" action ="<%=request.getContextPath()%>/orderBuy" onsubmit="return call();">
			<input type="hidden" name="cmd" value="2">
			<input type="hidden" name="id" value="<%=request.getAttribute("id") %>">
				<table style="margin: 0 auto 150px auto; border-spacing: 12px;">
				<tr>
					<th style= "width:200px; color: gray;">商品名：</th>
					<td><%=request.getAttribute("name") %></td>
				</tr>
				<tr>
					<th style= "width:200px; color: gray;">氏名：</th>
					<td><input id="name" style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;" type="text" size="25" name="user_name"></input></td>
				</tr>
				<tr>
					<th style= "width:200px; color: gray;">住所：</th>
					<th><input id="address" style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;" type=text size="25" name="address"></input></th>
				</tr>
				<tr>
				<th style=  "width:200px; color: gray;">メールアドレス：</th>
				<th><input id="email" style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;" type=text size="25" name="email"></input></hd>
				</tr>
				<tr>
					<th style= "width:200px; color: gray;">個数：</th>
						<td>
						<select style="border-radius: 12px; border: 3px solid pink;" name = "quantity">
							<option value = "1" selected>1
							<%for(int i=2; i<=stock; i++){ %>
							<option value = "<%=i%>"><%=i %>
							<%} %>
						</select>
						</td>
				</tr>
				<tr>
					<td></td>
					<td style= "color: gray;">(残り<%=stock %>個)</td>
				</tr>
				<tr>
					<th style= "width:200px; color: gray;">備考</th>
					<td><textarea name="content" style="border-radius: 12px; border: 3px solid pink;" cols="27" rows="10"></textarea></td>
				</tr>

				<tr>
					<td colspan=2 style="text-align: center;"><input style=" margin-top: 30px;  background: none; border-radius: 4px; border: 1px solid; padding: 2px 6px; border-radius: 12px; border: 3px solid pink;" type="submit" value="購入"></td>
				</tr>
		</table>
		</form>
		</div>

	<%}else{ %>
	<!-- 会員の注文画面 -->
	<div align = "center">
			<h2  style="color: gray;">注文内容</h2>
			<form style="margin-top: 20px;" action ="<%=request.getContextPath()%>/orderBuy" onsubmit="return call();">
			<input type="hidden" name="cmd" value="2">
			<input type="hidden" name="id" value="<%=request.getAttribute("id") %>">
				<table style="margin: 0 auto 150px auto; border-spacing: 12px;">
				<tr>
					<th style= "width:200px; color: gray;">商品名：</th>
					<td><%=request.getAttribute("name") %></td>
				</tr>
				<tr>
					<th style= "width:200px; color: gray;">氏名：</th>
					<td><input id="name" value="<%=a.getName() %>" style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;" type="text" size="25" name="user_name"></input></td>
				</tr>
				<tr>
					<th style= "width:200px; color: gray;">住所：</th>
					<th><input id="address" value="<%=a.getAddress() %>" style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;" type=text size="25" name="address"></input></th>
				</tr>
				<tr>
				<th style=  "width:200px; color: gray;">メールアドレス：</th>
				<th><input id="email" value="<%=a.getEmail() %>" style="width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none;" type=text size="25" name="email"></input></hd>
				</tr>
				<tr>
					<th style= "width:200px; color: gray;">個数：</th>
						<td>
						<select style="border-radius: 12px; border: 3px solid pink;" name = "quantity">
							<option value = "1" selected>1
							<%for(int i=2; i<=stock; i++){ %>
							<option value = "<%=i%>"><%=i %>
							<%} %>
						</select>
						</td>
				</tr>
				<tr>
					<td></td>
					<td style= "color: gray;">(残り<%=stock %>個)</td>
				</tr>
				<tr>
					<th style= "width:200px; color: gray;">備考</th>
					<td><textarea name="content" style="border-radius: 12px; border: 3px solid pink;" cols="27" rows="10"></textarea></td>
				</tr>

				<tr>
					<td colspan=2 style="text-align: center;"><input style=" margin-top: 30px;  background: none; border-radius: 4px; border: 1px solid; padding: 2px 6px; border-radius: 12px; border: 3px solid pink;" type="submit" value="購入"></td>
				</tr>
		</table>
		</form>
		</div>






	<%}}else{ %>
	<!-- 注文内容確認画面 -->
		<div align = "center">
			<h2  style="color: gray;">注文内容確認</h2>
			<h3 style="text-align: center; color: gray;">以下の注文内容を確認してください。</h3>

			<form style="margin-top: 20px;" action ="<%=request.getContextPath()%>/orderBuy" onsubmit="return confirm();">
			<input type="hidden" name="cmd" value="3">
			<input type="hidden" name="id" value="<%=request.getAttribute("id") %>">
			<input type="hidden" name="name" value="<%=order.getUniform_name() %>">
			<input type="hidden" name="user_name" value="<%=order.getUser_name() %>">
			<input type="hidden" name="address" value="<%=order.getAddress() %>">
			<input type="hidden" name="email" value="<%=order.getEmail() %>">
			<input type="hidden" name="quantity" value="<%=order.getQuantity() %>">
			<input type="hidden" name="content" value="<%=order.getContent() %>">
				<table style="margin: 0 auto 150px auto; border-spacing: 12px;">
				<tr>
					<th style= "width:200px; color: gray;">商品名：</th>
					<td><%=order.getUniform_name()%></td>
				</tr>
				<tr>
					<th style= "width:200px; color: gray;">氏名：</th>
					<td><%=order.getUser_name()%></td>
				</tr>
				<tr>
					<th style= "width:200px; color: gray;">住所：</th>
					<td><%=order.getAddress()%></td>
				</tr>
				<tr>
					<th style=  "width:200px; color: gray;">メールアドレス：</th>
					<td><%=order.getEmail()%></td>
				</tr>
				<tr>
					<th style= "width:200px; color: gray;">個数：</th>
					<td><%=order.getQuantity() %></td>
				</tr>
				<tr>
					<th style= "width:200px; color: gray;">備考：</th>
					<td><%=order.getContent() %></td>
				</tr>
				<tr>
					<td colspan="2"><h3 style="text-align: center; color: gray;">総計価格は<%=df.format(order.getQuantity()*order.getPrice()) %>円になります。</h3></td>
				</tr>

				<tr>
					<td colspan=2 style="text-align: center;"><input style=" margin-top: 30px;  background: none; border-radius: 4px; border: 1px solid; padding: 2px 6px; border-radius: 12px; border: 3px solid pink;" type="submit" value="確認して購入"></td>
				</tr>
		</table>
		</form>
		</div>

	<%} %>


				<script type="text/javascript">
	function isEmpty(input) {

		return !input.value; //값이 없어서 거짓.

	}

	//<input>을 넣어서
	// 숫자가 아니면 true, 숫자면 false
	function isNotNumber(input) {
		return isNaN(input.value);
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

	// 공백(스페이스 바) 체크
	function checkSpace(str) {
		if (str.search(/\s/) !== -1) {
			return true;
			// 스페이스가 있는 경우
		} else {
			return false; // 스페이스 없는 경우
		}
	}

	let name = document.getElementById('name');
	let address = document.getElementById('address');
	let email = document.getElementById('email');

	function call() {

		if (isEmpty(name)) {
			alert("氏名を入力してください。");
			name.value = "";
			name.focus();
			return false;
		}

		if (isEmpty(address)) {
			alert("住所を入力してください。");
			address.value = "";
			address.focus();
			return false;
		}

		if (isEmpty(email)) {
			alert("メールアドレスを入力してください。");
			email.value = "";
			email.focus();
			return false;
		}

		if (cnt == 1) {
			return false;
		}

		return true;

	}

	function confirm(){
		confirm("購入しますか？");
	}


</script>



	</body>

</html>