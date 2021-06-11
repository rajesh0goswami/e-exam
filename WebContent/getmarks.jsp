<%@page import="java.sql.DriverManager"%>
    <%@page import="java.sql.ResultSet"%>
        <%@page import="java.sql.Statement"%>
            <%@page import="java.sql.Connection"%>
                <%
String id = request.getParameter("userid");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost/";
String database = "exam_student";
String userid = "root";
String password = "root";
String user=request.getParameter("un");
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
                    <style>
                        body {
                            background: #a874af;
                        }
                        
                        form {
                            width: 60%;
                            margin: 60px auto;
                            background: #efefef;
                            padding: 60px 120px 80px 120px;
                            text-align: center;
                            -webkit-box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
                            box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.1);
                        }
                        
                        label {
                            display: block;
                            position: relative;
                            margin: 40px 0px;
                        }
                        
                        .label-txt {
                            position: absolute;
                            top: -1.6em;
                            padding: 10px;
                            font-family: sans-serif;
                            font-size: .8em;
                            letter-spacing: 1px;
                            color: rgb(120, 120, 120);
                            transition: ease .3s;
                        }
                        
                        .input {
                            width: 100%;
                            padding: 10px;
                            background: transparent;
                            border: none;
                            outline: none;
                        }
                        
                        .line-box {
                            position: relative;
                            width: 100%;
                            height: 2px;
                            background: #BCBCBC;
                        }
                        
                        .line {
                            position: absolute;
                            width: 0%;
                            height: 2px;
                            top: 0px;
                            left: 50%;
                            transform: translateX(-50%);
                            background: #8BC34A;
                            transition: ease .6s;
                        }
                        
                        .input:focus+.line-box .line {
                            width: 100%;
                        }
                        
                        .label-active {
                            top: -3em;
                        }
                        
                        button {
                            display: inline-block;
                            padding: 12px 24px;
                            background: rgb(220, 220, 220);
                            font-weight: bold;
                            color: rgb(120, 120, 120);
                            border: none;
                            outline: none;
                            border-radius: 3px;
                            cursor: pointer;
                            transition: ease .3s;
                        }
                        
                        #ll {
                            padding-left: 10%;
                        }
                        
                        button:hover {
                            background: #8BC34A;
                            color: #ffffff;
                        }
                        
                        #al {
                            visibility: hidden;
                        }
                    </style>

                    <body>


                        <form>
                            <h1>Your Marks</h1>
                            <table style="width: 100%;padding-right: 10%;padding-top: 10%;">
                                <th style="font-family: Verdana, Geneva, Tahoma, sans-serif;">Python</th>
                                <th style="font-family: Verdana, Geneva, Tahoma, sans-serif;">Java</th>
                                <th style="font-family: Verdana, Geneva, Tahoma, sans-serif;">C++</th>
                                <th style="font-family: Verdana, Geneva, Tahoma, sans-serif;">C</th>
                                <%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from student where uname="+'\''+user+'\'';
resultSet = statement.executeQuery(sql);

while(resultSet.next()){
%>

                                    <tr>
                                        <td style="padding-top: 10%;color: red;font-weight: bold;">
                                            <%=resultSet.getString("marks1") %>
                                        </td>


                                        <td style="padding-top: 10%;color: red;font-weight: bold;">
                                            <%=resultSet.getString("marks2") %>
                                        </td>


                                        <td style="padding-top: 10%;color: red;font-weight: bold;">
                                            <%=resultSet.getString("marks3") %>
                                        </td>


                                        <td style="padding-top: 10%;color: red;font-weight: bold;">
                                            <%=resultSet.getString("marks4") %>
                                        </td>
                                    </tr>

                                    <%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
                            </table>
                        </form>
                    </body>

                    </html>