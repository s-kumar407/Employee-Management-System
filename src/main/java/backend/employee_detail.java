package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.x.protobuf.MysqlxResultset.ContentType_BYTES;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/employee_detail")
public class employee_detail extends HttpServlet{

	employeeId employeeId= new employeeId();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = new PrintWriter(System.out);
		
		 try {
			 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo","root","root");
			
			int newUserId=employeeId.employeeIdGenerator();
			String newUserName=req.getParameter("name");
			String newUserEmail=req.getParameter("email");
			String newUserPassword=req.getParameter("password");
			String newUserGender=req.getParameter("gender");
			String newUserCity=req.getParameter("city");
			
			
			PreparedStatement ps = con.prepareStatement("insert into employeedetail values(?,?,?,?,?,?)");
		
			ps.setInt(1,newUserId);
			ps.setString(2,newUserName);
			ps.setString(3,newUserEmail);
			ps.setString(4,newUserPassword);
			ps.setString(5,newUserGender);
			ps.setString(6,newUserCity);
			
			int count = ps.executeUpdate();
		
			
			HttpSession hs = req.getSession();
			
			hs.setAttribute("newUserId", newUserId);
			hs.setAttribute("newUserName", newUserName);
			hs.setAttribute("newUserEmail", newUserEmail);
			hs.setAttribute("newUserPassword", newUserPassword);
			hs.setAttribute("newUserGender", newUserGender);
			hs.setAttribute("newUserCity", newUserCity);
			
			
			if (count>0) {
				
				RequestDispatcher rd = req.getRequestDispatcher("/new_Employee_Detail.jsp");
			    rd.forward(req, resp);
			    
			}
			else {
				
				//resp.setContentType("text/html");
				out.print("<h3> User not register due to some error </h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/SignUp.jsp");
			    rd.include(req, resp);
			}
		
				
		} catch (Exception e) {
		
			System.out.println(e);
			out.print(e);
			
		}
		
	}
	
	
}

  class employeeId{
	  
	  static int id=1;
	  
	  public int employeeIdGenerator() {
		
		  return id++;
	}
	    
  }
