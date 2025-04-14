<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>＜output＞プログラミング課題中級演習02</title>
</head>
<body>
	<!-- 現在の日付を取得-->
	<p>
		現在の日付:
		<%=request.getAttribute("nowdate")%></p>
	<!--現在の時間を取得-->
	<p>
		現在の時刻:
		<%=request.getAttribute("nowtime")%></p>
	<!-- 指定時間後の時刻 ""-->
	<p><%=request.getAttribute("num1")%>時間後の時刻:
		<%=request.getAttribute("afterCalcHour")%>
	</p>

	<p>
		残り時間:
		<%=request.getAttribute("d4")%></p>

	<!-- 戻るボタン -->
	<form action="TimeServlet" method="get">
		<input type="submit" value="戻る">
	</form>
</body>
</html>