<%@page import="bean.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%Account a = (Account) session.getAttribute("accountList");
if(a == null) request.getRequestDispatcher("/view/login.jsp").forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者メニュー</title>

<%
		if (a.getAuthority() == 2) {
	%>
<style>
a:hover {
	opacity: 0.8;
}
</style>

<%}else{%>

<style>
a:hover {
	opacity: 0.8;
	background-color: LightPink;
}
</style>

<%}%>
</head>
<body>

	<%
		if (a.getAuthority() == 2) {
	%>
	<!-- 管理者画面 -->
	<div align="center">
			<header style=" width:900px; display: flex; justify-content: center; align-items: center; margin: 0 auto;">
				<img src="img/logo.png" alt="logo" width="70" height="70">
				<h1 style="padding-top:20px; margin-left: 12px;">株式会社神田ユニフォーム</h1>
				<h1 style="padding-top:20px;"></h1>
				</header>
				<%@ include file="/view/userInfo.jsp" %>
			<hr width="90%"></hr>

			<!-- コンテンツ（メニュー部分） -->
			<table style="padding-top:30px; border-spacing: 32px;">
				<tr><td align="center"><a href="<%=request.getContextPath()%>/uniformList" style="text-decoration:none; border: 1px solid black; border-radius: 3px; padding: 4px 120px">【商品一覧】</a></td></tr>
				<tr><td align="center"><a href="<%=request.getContextPath()%>/orderHistory" style="text-decoration:none; border: 1px solid black; border-radius: 3px; padding: 4px 120px">【受注一覧】</a></td></tr>
				<tr><td align="center"><a href="<%=request.getContextPath()%>/view/uniformInsert.jsp" style="text-decoration:none; border: 1px solid black; border-radius: 3px; padding: 4px 120px">【商品登録】</a></td></tr>
				<tr><td align="center"><a href="<%=request.getContextPath()%>/logout" style="text-decoration:none; border: 1px solid black; border-radius: 3px; padding: 4px 112px">【ログアウト】</a></td></tr>

			</table>
		</div>
	<%
		} else {
	%>
	<!-- ユーザー画面 -->
	<div align="center">

		<header
			style="width: 900px; display: flex; justify-content: center; align-items: center; margin: 50px auto 0 auto;">
			<img src="img/logo.png" alt="logo" width="70" height="70">
			<h1 style="padding-top: 20px; margin-left: 12px; color: hotpink;">
				<span style="font-size: 0.8em; color: gray;">株式会社</span>神田ユニフォーム
			</h1>
		</header>
		<%@ include file="/view/userInfo.jsp" %>
		<hr size="8" color="LightPink" width="90%"></hr>

		<!-- コンテンツ（メニュー部分） -->
		<table style="padding-top: 30px; border-spacing: 32px;">
			<tr>
				<td align="center"><a href="<%=request.getContextPath()%>/uniformList""
					style="text-decoration: none; border: 3px solid Pink; border-radius: 8px; padding: 4px 120px; color: gray; font-weight: 900;">【商品一覧】</a></td>
			</tr>
			<tr>
				<td align="center"><a href="<%=request.getContextPath()%>/orderHistory"
					style="text-decoration: none; border: 3px solid Pink; border-radius: 8px; padding: 4px 120px; color: gray; font-weight: 900;">【注文一覧】</a></td>
			</tr>
			<tr>
				<td align="center"><a href="<%=request.getContextPath()%>/accountUpdate"
					style="text-decoration: none; border: 3px solid Pink; border-radius: 8px; padding: 4px 104px; color: gray; font-weight: 900;">【会員情報変更】</a></td>
			</tr>
			<tr>
				<td align="center"><a href="<%=request.getContextPath()%>/logout"
					style="text-decoration: none; border: 3px solid Pink; border-radius: 8px; padding: 4px 112px; color: gray; font-weight: 900;">【ログアウト】</a></td>
			</tr>
		</table>
	</div>

	<%
		}
	%>

</body>
</html>