<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.text.*, bean.Account"%>
<%Account a = (Account) session.getAttribute("accountList");
int auth = 0;
if(a != null) {
	auth = a.getAuthority();
}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>

	<div align="center">
	<!-- 管理者 -->
	<%if(auth==2){ %>
	<header style=" width:900px; display: flex; justify-content: center; align-items: center; margin: 0 auto;">
			<img src="https://postfiles.pstatic.net/MjAyMzA2MjdfMjcy/MDAxNjg3ODMxMTk3NzMx.y2U6FThvXwdOi9XToRwE2N4H_hRXqdkBoCeK2m9852Mg.qxG3IdUM9aHf2hR4frt1B7kkSVwn5eb_OthgeJAIE04g.PNG.hyh3700/logo.png?type=w773" alt="logo" width="70" height="70">
				<h1 style="padding-top:20px; margin-left: 12px;">株式会社神田ユニフォーム</h1>
				<h1 style="padding-top:20px;"></h1>
		</header>
		<hr width="90%"></hr>
	<%}else{ %>
	<!-- ユーザー -->
				<header
			style="width: 900px; display: flex; justify-content: center; align-items: center; margin: 50px auto 0 auto;">
			<img src="https://postfiles.pstatic.net/MjAyMzA2MjdfMjcy/MDAxNjg3ODMxMTk3NzMx.y2U6FThvXwdOi9XToRwE2N4H_hRXqdkBoCeK2m9852Mg.qxG3IdUM9aHf2hR4frt1B7kkSVwn5eb_OthgeJAIE04g.PNG.hyh3700/logo.png?type=w773" alt="logo" width="70" height="70">
			<h1 style="padding-top: 20px; margin-left: 12px; color: hotpink;">
				<span style="font-size: 0.8em; color: gray;">株式会社</span>神田ユニフォーム
			</h1>
		</header>
		<hr size="8" color="LightPink" width="90%"></hr>
	<%} %>
		<h2>処理が完了しました。</h2>
		<br>
		<p>
			<a href="<%=request.getContextPath()%>/view/menu.jsp">【メニュー画面に戻る】</a>
		</p>

	</div>

</body>
</html>