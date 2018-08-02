<html>
<head>
<title>Big and Small</title>
</head>
<body>
<span style="color:red;">
<%
	int[] a=(int[])request.getAttribute("arr");
	out.println(a[0]);
%>
</span>
<span style="color:green;">
<%
	out.println(a[1]);
%>
</span>
</body>
</html>