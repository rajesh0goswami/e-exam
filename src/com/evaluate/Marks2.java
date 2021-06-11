package com.evaluate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Marks
 */
@WebServlet("/Marks2")
public class Marks2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Marks2() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		String uname=request.getParameter("user");
		int sum;
		System.out.println("marks");
		try {
	    	// JDBC driver name and database URL
	    	    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	    	    final String DB_URL = "jdbc:mysql://localhost/exam_student";

	    	   //  Database credentials
	    	    final String USER = "root";
	    	   final String PASS = "root";
	    	   response.setContentType("text/html");

	              PrintWriter out = response.getWriter(); 
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
			    
			     stmt = conn.prepareStatement("select SUM(mark) from evaluate where uname="+'\''+uname+'\'');
			     ResultSet rs=stmt.executeQuery();  
			     if(rs.next()){

			    	 sum=rs.getInt(1);
			    	 
			    	 stmt = conn.prepareStatement("UPDATE  student SET marks2=? WHERE uname="+'\''+uname+'\'');
				      stmt.setInt(1,sum);
				      stmt.executeUpdate();
			    	 
				    	 System.out.println("marks="+sum);
				     }
				     
			    	 System.out.println(" ================...");
				     stmt = conn.prepareStatement("Delete  from  evaluate where uname="+'\''+uname+'\'');
				     
				     
				      stmt.executeUpdate();
				      System.out.println("table clean..................");
				      
				      
					   
			    		
 RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
				      
				      dispatcher.forward(request, response);
			   
			     
			     
			     
			     
			    
			    

    
	   }
	    catch(Exception e)
	    {
	  	  System.out.println("wrong");
	  	  e.printStackTrace();
	    }

		
		
		
		
	}

}
