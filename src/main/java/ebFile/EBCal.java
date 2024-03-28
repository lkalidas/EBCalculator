package ebFile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EBCal
 */
public class EBCal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out =response.getWriter();
//			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			String a= request.getParameter("name");
			String b= request.getParameter("password");
			PreparedStatement pst= con.prepareStatement("Select user_name from user_login where user_name=? and password=?");
			pst.setString(1, a);
			pst.setString(2, b);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
				rd.forward(request,response);
			}else {
				out.println("<font color=red>Wrong password or username");
				RequestDispatcher rd= request.getRequestDispatcher("calculator.jsp");
				rd.include(request,response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
