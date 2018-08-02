<html>
<head>
<title>Greetings JSP</title>
</head>
<body>
<%
	out.println(request.getAttribute("msg"));
%>
</body>
</html>