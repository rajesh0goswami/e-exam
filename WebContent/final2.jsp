<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

String user=request.getParameter("user");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="./Marks2?user=<%=user %>" method="post">
<input type= "submit" value = "Final Submit" id="final" name="final">
</form>

</body>
</html>