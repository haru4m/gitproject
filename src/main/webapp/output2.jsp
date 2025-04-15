<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
int i = <%=request.getParameter("one")%>
int x = <%=request.getParameter("twice")%>
String z = <%=request.getParameter("culc")%>
int a = 0;


switch(z){
case "add":
	a = i + x ;
	break;
case "minus":
	a = i - x;
	break;
case "multiply":
	a= i * x;
	break;
case "division":
	a = i / x;
}


</script>
<p>計算結果</p>
<p><%=request.getParameter("one") %></p>
<p><%=request.getParameter("culc") %></p>
<p><%=request.getParameter("twice") %></p>



</body>
</html>