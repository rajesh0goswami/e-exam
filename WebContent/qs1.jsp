
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
int qsno;
String qs;
String a;
String b;
String c;
String d;
String user=request.getParameter("user");
System.out.println("User name from qs1 "+ user);
String no = request.getParameter("no");
System.out.println(no);
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost/";
String database = "exam_student";
String userid = "root";
String password = "root";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>

<body>


<h1>Subject -- Python</h1>

<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from sub1qs where qsno="+'\''+no+'\'';
resultSet = statement.executeQuery(sql);
if(resultSet.next()){

	qsno= resultSet.getInt(1);
	qs= resultSet.getString(2);
	a=resultSet.getString(3);
	b=resultSet.getString(4);
	c=resultSet.getString(5);
	d=resultSet.getString(6);
	
}
%>
<form action = "./Evaluate1?no=<%=resultSet.getInt("qsno") %>&user=<%=user %>" method = "post">
<h3><%=resultSet.getString("qsno") %></h3>
<h3><%=resultSet.getString("question") %></h3>
<input type="radio" id="a" name="a" value="a">
<label for="male"><%=resultSet.getString("a") %></label><br>
<input type="radio" id="b" name="a" value="b">
<label for="male"><%=resultSet.getString("b") %></label><br>
<input type="radio" id="c"  name="a" value="c">
<label for="male"><%=resultSet.getString("c") %></label><br>
<input type="radio" id="d" name="a" value="d">
<label for="male"><%=resultSet.getString("d") %></label><br>
<input type= "submit" value = "Save and Next" id="sub" name="sub">
</form >

<form action="./Clear1?no=<%=resultSet.getInt("qsno") %>&user=<%=request.getParameter("user") %>" method="post">
<input type= "submit" value = "Clear Response" id="clr" name="clr">
</form>

<form action="./Marks?user=<%=user %>" method="post">
<input type= "submit" value = "Final Submit" id="final" name="final">
</form>
<%

connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

</body>
</html>
