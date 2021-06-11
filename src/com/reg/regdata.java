package com.reg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class regdata
 */
@WebServlet("/regdata")
public class regdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String techskill="";
		String s1=request.getParameter("java");
		if(s1!=null)
		{
			techskill+=s1+" ";
		}
		String s2=request.getParameter("jsp");
		if(s2!=null)
		{
			techskill+=s2+" ";
		}
		String s3=request.getParameter("c");
		if(s3!=null)
		{
			techskill+=s3+" ";
		}
		String s4=request.getParameter("py");
		if(s4!=null)
		{
			techskill+=s4+" ";
		}
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(techskill);
		
		
		
		
		try {
	    	// JDBC driver name and database URL
	    	    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	    	    final String DB_URL = "jdbc:mysql://localhost/exam_student";

	    	   //  Database credentials
	    	    final String USER = "root";
	    	   final String PASS = "root";
	    	System.out.println("hi");
   Connection conn = null;
   PreparedStatement stmt = null;
  
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);
   
      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.prepareStatement("insert into student  values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
      stmt.setString(1, request.getParameter("name"));
      
      stmt.setString(2, request.getParameter("id"));
      stmt.setString(3, request.getParameter("email"));
      stmt.setString(4, request.getParameter("pass"));
      stmt.setInt(5,0);
      stmt.setInt(6,0);
      stmt.setInt(7,0);
      stmt.setInt(8,0);
      stmt.setString(9, request.getParameter("file"));
      stmt.setInt(10, Integer.parseInt(request.getParameter("age")));
      stmt.setString(11, request.getParameter("addr"));
      stmt.setString(12, request.getParameter("branch"));
      stmt.setString(13, techskill);
     
      stmt.executeUpdate();
      System.out.println("Inserted records into the table...");
request.getRequestDispatcher("index.html").forward(request, response);
	    	
	   }
	    catch(Exception e)
	    {
	  	  System.out.println("wrong");
	  	request.getRequestDispatcher("regform.html").forward(request, response);
	  	  e.printStackTrace();
	    }
	}
	}


