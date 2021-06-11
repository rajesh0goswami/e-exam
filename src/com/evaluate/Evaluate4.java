package com.evaluate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Evaluate
 */
@WebServlet("/Evaluate4")
public class Evaluate4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Evaluate4() {
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
		
		
		
		
		
		String user =request.getParameter("user");
		 String op = request.getParameter("sub");
		 System.out.println("working on "+op);
		 System.out.println("Incide evaluate");
		
			String corr;
			String ans=request.getParameter("a");
			String b=request.getParameter("b");
			String c=request.getParameter("c");
			String d=request.getParameter("d");
			int x;
			
			System.out.println(ans);
//			System.out.println(b);
//			System.out.println(c);
//			System.out.println(d);
			
			int no=Integer.parseInt(request.getParameter("no"));
			System.out.println(no);
			int next =no+1;
			 
				
			if(no==10)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("final4.jsp?sub="+op+"&user="+user);
			      
				dispatcher.forward(request, response);
				
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("qs4.jsp?no="+next);
			      
				dispatcher.forward(request, response);
			}
				
			 
				
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
					    
					     stmt = conn.prepareStatement("select * from sub4qs where qsno="+'\''+no+'\'');
					     ResultSet rs=stmt.executeQuery();  
					     if(rs.next()){

					    	 corr=rs.getString(7);
					    	 System.out.println(corr);
					    	 System.out.println(ans);
					    	 if(ans.equals(corr)) {
						    	 x=1;
						    	 System.out.println("Correct ans");
						     }
						     else {
						    	 x=0;
						    	 System.out.println("Wrong ans");
						     }
					    	 System.out.println("Inserting records into the table...");
						     stmt = conn.prepareStatement("insert into evaluate values(?,?,?,?)");
						     stmt.setString(1,user);
						      
						      stmt.setString(2, request.getParameter("no"));
						      stmt.setString(3, request.getParameter("a"));
						      stmt.setInt(4,x);
						     
						      stmt.executeUpdate();
						      System.out.println("Inserted records into the table...");
					    		
					    	}
					   
					     
					     
					     
					     
					    
					    

		    
			   }
			    catch(Exception e)
			    {
			  	  System.out.println("wrong");
			  	  e.printStackTrace();
			    }

				
			
//			else {
//				try {
//			    	// JDBC driver name and database URL
//			    	    final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
//			    	    final String DB_URL = "jdbc:mysql://localhost/exam_student";
//
//			    	   //  Database credentials
//			    	    final String USER = "root";
//			    	   final String PASS = "root";
//			    	   response.setContentType("text/html");
//
//			              PrintWriter out = response.getWriter(); 
//			              System.out.println("hi");
//						 Connection conn = null;
//						 PreparedStatement stmt = null;
//		 
//		     //STEP 2: Register JDBC driver
//					     Class.forName(JDBC_DRIVER);
//					  
//					     //STEP 3: Open a connection
//					     System.out.println("Connecting to a selected database...");
//					     conn = DriverManager.getConnection(DB_URL, USER, PASS);
//					     System.out.println("Connected database successfully...");
//					     
//					     //STEP 4: Execute a query
//					    
//					     System.out.println("DELETE records into the table...");
//					      stmt = conn.prepareStatement("DELETE FROM evaluate where qsno=?");
//					     
//					      stmt.setInt(1, no);
//					      stmt.executeUpdate();
//					    		
//					    	}
//					   
//					     
//					     
//					     
//					     
//					    
//					    
//
//		    
//			   
//			    catch(Exception e)
//			    {
//			  	  System.out.println("wrong");
//			  	  e.printStackTrace();
//			    }
//
//				
//			}
	       
	       
			
		
		
		
	}

}
