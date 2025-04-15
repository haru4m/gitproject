<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Output2 (計算結果)</title>
</head>
<body>
	<p>計算結果</p>
	<!-- （計算結果 or エラー）を取得 -->
	<p1><%=request.getAttribute("ans")%></p>
	<p3> <!-- 最初のページに戻るためのボタン -->
	<form action="Culc" method="get">
		<input type="submit" value="戻る">
	</form>
</body>
</html>