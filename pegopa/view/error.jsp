<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラーページ</title>
</head>
<body>

	<div align="center">
			<header style=" width:900px; display: flex; justify-content: center; align-items: center; margin: 0 auto;">
				<img src="logo.png" alt="logo" width="70" height="70">
				<h1 style="padding-top:20px; margin-left: 12px;">株式会社神田ユニフォーム</h1>
				<h1 style="padding-top:20px;"></h1>
				</header>
				<hr width="90%"></hr>

			<h2>エアーが発生しました。</h2>
			<br>
			<p><a href="<%=request.getContextPath()%>/logout">【メニュー画面に戻る】</a></p>

		</div>


</body>
</html>