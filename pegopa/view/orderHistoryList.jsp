<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.text.*, bean.Order, bean.Account"%>
<%ArrayList<Order> list = (ArrayList<Order>)request.getAttribute("order_list");
SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
DecimalFormat df = new DecimalFormat("###,###");
int sales_present = 0;
int sales_past = 0;
int nowmonth = 0;
int auth = 0;
Account a = (Account) session.getAttribute("accountList");
if(a == null) {
	request.getRequestDispatcher("/view/login.jsp").forward(request, response);
}else{
	auth = a.getAuthority();
	if(auth==2){
		sales_present = (int)request.getAttribute("sales_present");
		sales_past = (int)request.getAttribute("sales_past");
		nowmonth = (int)request.getAttribute("nowmonth");
	}
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文一覧</title>
</head>
<body>





<%if(auth==2){ %>
<!-- 管理者画面 -->

<div align="center">
			<header style=" width:900px; display: flex; justify-content: center; align-items: center; margin: 0 auto;">
			<img src="https://postfiles.pstatic.net/MjAyMzA2MjdfMjcy/MDAxNjg3ODMxMTk3NzMx.y2U6FThvXwdOi9XToRwE2N4H_hRXqdkBoCeK2m9852Mg.qxG3IdUM9aHf2hR4frt1B7kkSVwn5eb_OthgeJAIE04g.PNG.hyh3700/logo.png?type=w773" alt="logo" width="70" height="70">
				<h1 style="padding-top:20px; margin-left: 12px;">株式会社神田ユニフォーム</h1>
				<h1 style="padding-top:20px;"></h1>
		</header>
			<table align="left" style="padding-bottom:5px; padding-left:10%;">
				<tr>
					<td align="center"><a href="<%=request.getContextPath() %>/view/menu.jsp" style="text-decoration:none;">【メニュー】</a></td>
					<td align="center"><a href="<%=request.getContextPath() %>/view/login.jsp" style="text-decoration:none;">【ログアウト】</a></td>
				</tr>
			</table>
			<hr width="90%"></hr>

			<h2 style="padding-top:20px; text-align: center;">受注一覧</h2>

			<div style="display: flex; flex-direction: column; padding: 0 10%;">

			<table style="display: flex; justify-content: right;">
				<tr>
					<td colspan=8 style="text-align:right;"><%=nowmonth %>月の売り上げ(発送完了分)</td>
					<td colspan=9>￥<%=df.format(sales_present) %></td>
				</tr>
				<tr>
					<td colspan=8 style="text-align:right;"><%=nowmonth-1 %>月の売り上げ(発送完了分)</td>
					<td colspan=9>￥<%=df.format(sales_past) %></td>
				</tr>
			</table>

			<table cellspacing="2" style="text-align:center; padding-top:30px;">
				<tr>
					<th bgcolor="#66CC99" width="130">No</th>
					<th bgcolor="#66CC99" width="180">氏名</th>
					<th bgcolor="#66CC99" width="200">種類</th>
					<th bgcolor="#66CC99" width="100">個数</th>
					<th bgcolor="#66CC99" width="200">合計金額</th>
					<th bgcolor="#66CC99" width="200">発注日</th>
					<th bgcolor="#66CC99" width="180">入金状況</th>
					<th bgcolor="#66CC99" width="180">発送状況</th>
					<th bgcolor="#66CC99" width="180">&nbsp;</th>
				</tr>

		<%
			if(list != null){
				for(int i=0;i<list.size();i++){
					Order order = (Order)list.get(i);
		%>
				<tr>
					<td width="130"><%=order.getId() %></td>
					<td width="180"><%=order.getUser_name() %></td>
					<td width="200"><%=order.getUniform_name() %></td>
					<td width="100"><%=order.getQuantity() %></td>
					<td width="200">\<%=df.format(order.getQuantity()*order.getPrice()) %></td>
					<td width="200"><%=sf.format(order.getOrderdate()) %></td>
					<td width="180"><%=order.getDeposit() %></td>
					<td width="180"><%=order.getShipping() %></td>
					<td width="180">
						<a href="<%=request.getContextPath()%>/orderHistoryUpdate?cmd=1&orderid=<%=order.getId()%>">詳細</a>
					</td>
				</tr>

		<%} } else{%>
				<tr>
					<td width="130"></td>
					<td width="180"></td>
					<td width="200"></td>
					<td width="100"></td>
					<td width="200"></td>
					<td width="200"></td>
					<td width="180"></td>
					<td width="180"></td>
					<td width="180"></td>
				</tr>

			<%} %>
			</table>
		  </div>
		</div>


<%}else{ %>
<!-- ユーザー画面 -->
		<div align="center">
					<header
			style="width: 900px; display: flex; justify-content: center; align-items: center; margin: 50px auto 0 auto;">
			<img src="https://postfiles.pstatic.net/MjAyMzA2MjdfMjcy/MDAxNjg3ODMxMTk3NzMx.y2U6FThvXwdOi9XToRwE2N4H_hRXqdkBoCeK2m9852Mg.qxG3IdUM9aHf2hR4frt1B7kkSVwn5eb_OthgeJAIE04g.PNG.hyh3700/logo.png?type=w773" alt="logo" width="70" height="70">
			<h1 style="padding-top: 20px; margin-left: 12px; color: hotpink;">
				<span style="font-size: 0.8em; color: gray;">株式会社</span>神田ユニフォーム
			</h1>
		</header>

			<table align="left" style="padding-bottom:5px; padding-left:10%;">
				<tr>
					<td align="center"><a href="<%=request.getContextPath() %>/view/menu.jsp" style="text-decoration:none;">【メニュー】</a></td>
					<td align="center"><a href="<%=request.getContextPath() %>/view/login.jsp" style="text-decoration:none;">【ログアウト】</a></td>
				</tr>
			</table>
		<hr size="8" color="LightPink" width="90%"></hr>

			<h2 style="padding-top:20px; text-align: center;">注文一覧</h2>

			<div style="display: flex; flex-direction: column; padding: 0 10%;">


			<table cellspacing="2" style="text-align:center; padding-top:30px;">
				<tr>
					<th bgcolor="LightPink" width="200">種類</th>
					<th bgcolor="LightPink" width="100">個数</th>
					<th bgcolor="LightPink" width="200">合計金額</th>
					<th bgcolor="LightPink" width="200">発注日</th>
					<th bgcolor="LightPink" width="180">入金状況</th>
					<th bgcolor="LightPink" width="180">発送状況</th>
				</tr>

		<%
			if(list != null){
				for(int i=0;i<list.size();i++){
					Order order = (Order)list.get(i);
		%>
				<tr>
					<td width="200"><%=order.getUniform_name() %></td>
					<td width="100"><%=order.getQuantity() %></td>
					<td width="200">\<%=df.format(order.getQuantity()*order.getPrice()) %></td>
					<td width="200"><%=sf.format(order.getOrderdate()) %></td>
					<td width="180"><%=order.getDeposit() %></td>
					<td width="180"><%=order.getShipping() %></td>
				</tr>

		<%} } else{%>
				<tr>
					<td width="130"></td>
					<td width="180"></td>
					<td width="200"></td>
					<td width="100"></td>
					<td width="200"></td>
					<td width="200"></td>
					<td width="180"></td>
					<td width="180"></td>
					<td width="180"></td>
				</tr>

			<%} %>
			</table>
		  </div>
		</div>









<%} %>

</body>
</html>