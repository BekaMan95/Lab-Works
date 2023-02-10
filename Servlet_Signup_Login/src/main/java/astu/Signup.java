package astu;

import java.io.IOException;
import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup
 */
//@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "jdbc:mysql://localhost:3306/bam";
    private String rName = "root";
    private String rpass = "12345678";
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String dept = request.getParameter("dept");
        String position = request.getParameter("pos");
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection(url,rName,rpass);
        	PreparedStatement ps = con.prepareStatement("insert into login values(?,?,?,?,?)");
        	ps.setString(1, username);
        	ps.setString(3, email);
        	ps.setString(4, dept);
        	ps.setString(5, position);
        	ps.setString(2, pass);
        	ps.executeUpdate();
        	con.close();
        	System.out.println("Sign up Successful!");
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        out.println("<h3>Sign up Sucessful!</h3><br>");
        out.println("<a href='Login.jsp'>Continue Login...</a>");
	}

}
