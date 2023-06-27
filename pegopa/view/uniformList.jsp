<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.text.*, bean.Uniform, bean.Account"%>
<%ArrayList<Uniform> list = (ArrayList<Uniform>)request.getAttribute("uniform_list");
DecimalFormat df = new DecimalFormat("###,###");
Account a = (Account) session.getAttribute("accountList");
int authority = 1;
if(a != null) authority = a.getAuthority();
String directory = request.getSession().getServletContext().getRealPath("/")+"img/";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文完了</title>

<style>
.product {
	text-decoration: none;
	color: black;
}

.product:hover {
	font-weight: bold;
}
</style>
<%if (authority == 1) {%>
<style>
.product:hover {
	background-color: pink;
	}
</style>
<%} %>
</head>

<body>
<!-- 管理者のメニュー画面 -->
<%if (authority == 2) {%>
<header style=" width:900px; display: flex; justify-content: center; align-items: center; margin: 0 auto;">
			<img src="img/logo.png" alt="logo" width="70" height="70">
			<h1 style="padding-top:20px; margin-left: 12px;">株式会社神田ユニフォーム</h1>
			<h1 style="padding-top:20px;"></h1>
			</header>

		<table align="left" style="padding-bottom:5px; padding-left:10%;">
				<tr>
					<td align="center"><a href="<%=request.getContextPath()%>/view/menu.jsp" style="text-decoration:none;">【メニュー】</a></td>
				</tr>
			</table>

			<hr width="90%"></hr>

		<h2 style="padding-top:20px;" align = "center">商品一覧</h2>

		<%
			if(list != null){
				for(int i=0;i<list.size();i++){
					Uniform uniform = (Uniform)list.get(i);
		%>

		<div>
		<a class="product"  href="<%=request.getContextPath()%>/uniformUpdate?cmd=1&id=<%=uniform.getId()%>" style="display: flex; justify-content: space-between; align-items: center; margin: 0 auto 22px auto; width: 250px; border: 2px solid black; border-radius: 8px; padding: 8px 65px;">
			<img src="img/<%=uniform.getImg() %>" alt="img" width="70" height="70">
			<div>
				<p><%=uniform.getName() %></p>
				<p>\<%=df.format(uniform.getPrice()) %></p>
			</div>
			</a>
		</div>


		<%} }else{%>

		<h3 style="text-align: center; color: gray;">表示する商品がありません。</h3>
		<div align = "center">
		<a style="display: inline-block; margin-top: 150px; border: 3px solid pink; border-radius: 8px; padding: 4px 8px; cursor: pointer; color: gray; font-weight: 900; text-decoration: none;" href = "view/menu.jsp">戻る</a>
		</div>

<!-- 一般ユーザーのメニュー画面 -->
<%} }else{%>
	<%@ include file="/common/header_user.jsp" %>

		<table align="left" style="padding-bottom:5px; padding-left:10%;">
			<tr>
				<td align="center"><a href="<%=request.getContextPath()%>/view/menu.jsp" style="text-decoration:none; color: gray; font-weight: 900;">【メニュー】</a></td>
			</tr>
			</table>

			<hr size="8" color="LightPink" width="90%"></hr>

		<h2 style="padding-top:20px; color: gray;" align = "center">商品一覧</h2>

		<%
			if(list != null){
				for(int i=0;i<list.size();i++){
					Uniform uniform = (Uniform)list.get(i);
		%>

		<div>
		<a class="product" href="<%=request.getContextPath()%>/orderBuy?cmd=1&id=<%=uniform.getId()%>" style="display: flex; justify-content: space-between; align-items: center; margin: 0 auto 22px auto; width: 250px; border: 3px solid lightpink; border-radius: 8px; padding: 8px 65px;">
			<img src="img/<%=uniform.getImg() %>" alt="img" width="70" height="70">
			<div>
			<p><%=uniform.getName() %></p>
			<p>\<%=df.format(uniform.getPrice()) %></p>
			</div>
			</a>
		</div>


		<%} }else{%>

		<h3 style="text-align: center; color: gray;">表示する商品がありません。</h3>
		<div align = "center">
		<a style="display: inline-block; margin-top: 150px; border: 3px solid pink; border-radius: 8px; padding: 4px 8px; cursor: pointer; color: gray; font-weight: 900; text-decoration: none;" href = "view/menu.jsp">戻る</a>
		</div>

		<%} }%>
</body>

</html>