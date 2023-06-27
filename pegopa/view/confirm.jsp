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
	<%@ include file="/common/header_user.jsp" %>
		<hr width="90%"></hr>
	<%}else{ %>
	<!-- ユーザー -->
		<%@ include file="/common/header_user.jsp" %>
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