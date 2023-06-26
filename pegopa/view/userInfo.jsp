<%@page import="bean.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	//セッションからユーザー情報を取得
	Account user = (Account) session.getAttribute("accountList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理システム</title>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/view/css/userInfo.css">
<style type="text/css">
.heading-035 {
    display: flex;
    align-items: center;
    gap: 0 7px;
    color: #333333;
}

.heading-035::before {
    width: 20px;
    height: 20px;
    background-image: url('data:image/svg+xml;charset=utf8,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20xml%3Aspace%3D%22preserve%22%20style%3D%22enable-background%3Anew%200%200%2024%2024%22%20viewBox%3D%220%200%2024%2024%22%20fill%3D%22%23ffb500%22%3E%3Cpath%20d%3D%22M19.8%2019.2H4.2c-.3%200-.6.3-.6.6V21c0%20.3.3.6.6.6h15.6c.3%200%20.6-.3.6-.6v-1.2c0-.3-.3-.6-.6-.6zm2.4-12c-1%200-1.8.8-1.8%201.8%200%20.3.1.5.2.7l-2.7%201.6c-.6.3-1.3.1-1.7-.4l-3.1-5.3c.4-.3.7-.8.7-1.4%200-1-.8-1.8-1.8-1.8s-1.8.8-1.8%201.8c0%20.6.3%201.1.7%201.4l-3.1%205.3c-.3.6-1.1.8-1.7.4L3.4%209.7c.1-.2.2-.4.2-.7%200-1-.8-1.8-1.8-1.8S0%208%200%209s.8%201.8%201.8%201.8h.3L4.8%2018h14.4l2.7-7.2h.3c1%200%201.8-.8%201.8-1.8s-.8-1.8-1.8-1.8z%22%2F%3E%3C%2Fsvg%3E');
    content: '';
}

#u_div{
float: right;
margin-right: 10%;
}

</style>
</head>
<body>
	<div id="u_div">
		<div>
			<h4 class="heading-035"><%=user.getName() %></h4>
		</div>

	</div>


</body>
</html>