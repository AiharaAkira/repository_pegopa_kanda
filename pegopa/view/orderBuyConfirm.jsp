<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="bean.Account, bean.Order, java.text.*"%>
<%Account a = (Account) session.getAttribute("accountList");
Order order = (Order)request.getAttribute("order");
DecimalFormat df = new DecimalFormat("###,###");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>注文完了</title>
	</head>

	<body>
		<header style=" width:900px; display: flex; justify-content: center; align-items: center; margin: 50px auto 0 auto;">
			<img src="img/logo.png" alt="logo" width="70" height="70">
			<h1 style="padding-top:20px; margin-left: 12px; color: hotpink;"><span style="font-size: 0.8em; color: gray;">株式会社</span>神田ユニフォーム</h1>
		</header>
			<hr size="8" color="LightPink" width="90%"></hr>

		<h2 style="padding-top:20px; text-align: center; color: gray;">注文完了</h2>
		<h3 style="text-align: center; color: gray;">ご購入ありがとうございます。<br>以下の内容でお承りしました。</h3>
		<h4 style="text-align: center; color: gray;">確認メールをお送りしましたのでご確認ください。</h4>

		<table width = "850" align = "center" style="text-align: center; margin-bottom: 150px;">
			<tr>
				<th bgcolor = "pink" width = "200">商品名</th>
				<th bgcolor = "pink" width = "200">個数</th>
				<th bgcolor = "pink" width = "200">価格</th>
			</tr>
			<tr>
				<td><%=order.getUniform_name()%></td>
				<td><%=order.getQuantity() %></td>
				<td>\<%=df.format(order.getQuantity()*order.getPrice()) %></td>
			</tr>

			<tr>
				<td colspan="3" style="text-align: center;"><a style="display: inline-block; margin-top: 150px; border: 3px solid pink; border-radius: 8px; padding: 4px 8px; cursor: pointer; color: gray; font-weight: 900; text-decoration: none;" href = "view/menu.jsp">戻る</a></td>
			</tr>
		</table>


	</body>

</html>