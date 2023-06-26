<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.*, bean.Order"%>
<%Order order = (Order)request.getAttribute("order");
SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
DecimalFormat df = new DecimalFormat("###,###");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報修正</title>
</head>
	<body>
		<div align="center">
			<header style=" width:900px; display: flex; justify-cont-ent: center; align-items: center; margin: 0 auto;">
				<img src="img/logo.png" alt="logo" width="70" height="70">
				<h1 style="padding-top:20px; margin-left: 12px;">株式会社神田ユニフォーム</h1>
				<h1 style="padding-top:20px;"></h1>
				</header>
			<table align="left" style="padding-bottom:5px; padding-left:10%;">
				<tr>
					<td align="center"><a href="<%=request.getContextPath() %>/view/menu.jsp" style="text-decoration:none;">【メニュー】</a></td>
					<td align="center"><a href="<%=request.getContextPath() %>/orderHistory" style="text-decoration:none;">【受注一覧】</a></td>
					<td align="center"><a href="<%=request.getContextPath() %>/view/login.jsp" style="text-decoration:none;">【ログアウト】</a></td>
				</tr>
			</table>
			<hr width="90%"></hr>

			<h2 style="padding-top:20px; text-align: center;">受注詳細</h2>

			<div style="display: flex; flex-direction: column; padding: 0 10%;">

			<table align="center" cellspacing="2" style="text-align:center; padding-top:30px; margin-bottom: 150px;">
				<tr>
					<th bgcolor="#66CC99">No</th><td><%=order.getId() %></td>
				</tr>
				<tr>
					<th bgcolor="#66CC99" width="">氏名</th><td width="180"><%=order.getUser_name() %></td>
				</tr>
				<tr>
					<th bgcolor="#66CC99" width="200">種類</th><td width="200"><%=order.getUniform_name() %></td>
				</tr>
				<tr>
					<th bgcolor="#66CC99" width="100">個数</th><td width="100"><%=order.getQuantity() %></td>
				</tr>
				<tr>
					<th bgcolor="#66CC99" width="200">合計金額</th><td width="200">\<%=df.format(order.getPrice()*order.getQuantity()) %></td>
				</tr>
				<tr>
					<th bgcolor="#66CC99" width="200">発注日</th><td width="200"><%=sf.format(order.getOrderdate()) %></td>
				</tr>

				<form action="<%=request.getContextPath() %>/orderHistoryUpdate">
				<input type="hidden" name="cmd" value="2">
				<input type="hidden" name="orderid" value="<%=order.getId() %>">
				<tr>
				<th bgcolor="#66CC99" width="180">入金状況</th>
					<td width="180">
					<%if(order.getDeposit().equals("入金待ち")){ %>
						<select name = "deposit">
							<option value = "入金待ち" selected>入金待ち
							<option value = "入金済">入金済
						</select>
					<%}else{ %>
						<select name = "deposit">
							<option value = "入金待ち">入金待ち
							<option value = "入金済" selected>入金済
						</select>
					<%} %>
					</td>
				</tr>
				<tr>
					<th bgcolor="#66CC99" width="180">発送状況</th>
					<td width="180">
					<%if(order.getShipping().equals("未")){ %>
						<select name = "shipping">
							<option value = "未" selected>未
							<option value = "発送済">発送済
						</select>
					<%}else{ %>
						<select name = "shipping">
							<option value = "未">未
							<option value = "発送済" selected>発送済
						</select>
					<%} %>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="更新" style="display: inline-block; margin-top: 50px; border: 1px solid black; border-radius: 4px; padding: 4px 8px; cursor: pointer; color: black; text-decoration: none;"></td>
					</tr>
				</form>
			</table>
			</div>
		</div>
	</body>
</html>