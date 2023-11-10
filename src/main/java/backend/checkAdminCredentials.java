package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.tagext.TryCatchFinally;

@WebServlet("/checkAdminCredential")
public class checkAdminCredentials extends HttpServlet {

	PrintWriter out = new PrintWriter(System.out);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo", "root", "root");

			PreparedStatement pStatement = con.prepareStatement("select * from admin");
			PreparedStatement ps = con.prepareStatement("select * from employeedetail");
			
		    ResultSet rSet = pStatement.executeQuery();
		    
		    ResultSet rs = ps.executeQuery();
		    
		    String adminEmail = req.getParameter("admin_email");
		    String adminPassword = req.getParameter("admin_password");
		    
		    HttpSession hs = req.getSession();
		    
		    hs.setAttribute("Total_Employee_Detail", rs);
		    
		    while(rSet.next()) {
		    	
		    if(adminEmail.equals(rSet.getString("email")) && adminPassword.equals(rSet.getString("password"))) {
		    	int adminId = rSet.getInt("id");
		    	String adminName = rSet.getString("name");
		    	String adminGender = rSet.getString("gender");
		    	String adminCity = rSet.getString("city");
		    	
		    	hs.setAttribute("adminId", adminId);
		    	hs.setAttribute("adminName", adminName);
		    	hs.setAttribute("adminEmail", adminEmail);
		    	hs.setAttribute("adminPassword", adminPassword);
		    	hs.setAttribute("adminGender", adminGender);
		    	hs.setAttribute("adminCity", adminCity);
		    	
		    	
		    	RequestDispatcher rDispatcher = req.getRequestDispatcher("/admin.jsp");
		    	rDispatcher.forward(req, resp);
		    	
		    }
		    }
		    out.print("<h3> Please provide right credentials!<h3>");
		    RequestDispatcher rDispatcher = req.getRequestDispatcher("/admin_log_in.jsp");
	    	rDispatcher.include(req, resp);

		} catch (Exception e) {

			System.out.println(e);
			
		}

	}

}
