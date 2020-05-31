package com.mahi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String Name=request.getParameter("First");
		String Email=request.getParameter("Second");
		String Cd=request.getParameter("Third");
		
		String qry="insert into spark.user value(?,?,?)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=CHANDAN100");
			PreparedStatement ps=con.prepareStatement(qry);
			ps.setString(1, Name);
			ps.setString(2, Email);
			ps.setString(3, Cd);
			ps.executeUpdate();
			
			response.sendRedirect("Save.html");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
