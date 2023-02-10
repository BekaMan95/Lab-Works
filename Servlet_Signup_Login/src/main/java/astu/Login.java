package astu;

import java.io.IOException;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "jdbc:mysql://localhost:3306/bam";
    private String rName = "root";
    private String rpass = "12345678";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,rName,rpass);
            PreparedStatement ps = con.prepareStatement("SELECT username FROM login where username=? and pass=?");
            ps.setString(1,username);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request,response);
                System.out.println("Login Successful!");
            }
            else
            {
            	out.println("<h3>User Name or Password is incorrect!</h3><br>");
            	out.println("<a href='Login.jsp'>Try again!</a>");           }
        }
        catch(Exception e) {
        	System.out.println(e);
        }
	}

}
