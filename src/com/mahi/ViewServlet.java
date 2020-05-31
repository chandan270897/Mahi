package com.mahi;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		String qry="select * from spark.user";
		try 
		{
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=CHANDAN100");
			PreparedStatement ps=con.prepareStatement(qry);
			ResultSet rs=ps.executeQuery();
			PrintWriter out=response.getWriter();
			out.println("<html><body bgcolor='grey'><table border='1'><tr><td>S.NO</td><td>Name</td><td>Email Id</td><td>Current Credit</td><td>User Details</td></tr>");
			int i=0;
			while(rs.next())
			{
				String name=rs.getString(1);
				String email=rs.getString(2);
				String Cd=rs.getString(3);
				i++;
				out.println("<tr><td>"+i+"</td><td>"+name+"</td><td>"+email+"</td><td>"+Cd+"</td>"
						+ "<td><form action='Detail'"+i+"><input type='submit' value=User"+i+"</from></td></tr>");
			}
			out.println("</table></body></html>");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
