<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String strA = request.getParameter("a");
int valueA = Integer.parseInt( strA );

String strB = request.getParameter("b");
int valueB = Integer.parseInt( strB );

out.print("Tong cua ");
out.print(valueA);
out.print("va ");
out.print(valueB);
out.print("la ");
out.print(valueA+valueB);
%>
</body>
</html>