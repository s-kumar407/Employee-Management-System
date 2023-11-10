package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkEmail&Password")
public class checkCredential extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = new PrintWriter(System.out);

		try {
			
			int count=1;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo","root","root");
			
            PreparedStatement pStatement=con.prepareStatement("select * from employeedetail");
			
            ResultSet rs=pStatement.executeQuery();
            
			String oldUserEmail = req.getParameter("email");
			String oldUserPassword = req.getParameter("password");

		    HttpSession hs= req.getSession();
			
		    hs.setAttribute("Total_Employee_Detail", rs);
			
			while (rs.next()) {

				System.out.println(count);
                 System.out.println(rs.getString("name"));
                 System.out.println(rs.getString("email"));
                 System.out.println(rs.getString("password"));
                 System.out.println(rs.getString("gender"));
                 System.out.println(rs.getString("city"));
                 System.out.println("------------------------------------");
				if (oldUserEmail.equals(rs.getString("email")) && oldUserPassword.equals(rs.getString("password"))) {
					//resp.setContentType("text/html");
					
						int oldUserId= rs.getInt("id");
						String oldUserName=rs.getString("name");
						String oldUserGender=rs.getString("gender");
						String oldUserCity=rs.getString("city");

                 
                      hs.setAttribute("oldUserId", oldUserId);
                      hs.setAttribute("oldUserName", oldUserName);
                      hs.setAttribute("oldUserEmail", oldUserEmail);
                      hs.setAttribute("oldUserPassword", oldUserPassword);
                      hs.setAttribute("oldUserGender", oldUserGender);
                      hs.setAttribute("oldUserCity", oldUserCity);
                      
                    //out.print("<h3 style='color:red'> User Log in succesfully !</h3>");
  					//RequestDispatcher rd = req.getRequestDispatcher("/employee_detail.jsp");
  					//rd.include(req, resp);
                      
					resp.sendRedirect("/Employee-Management-System/old_employee_detail.jsp");
					break;

				}
				count++;
			}

//			resp.setContentType("text/html");
//			out.print("<h3> Please provide right credentials !</h3>");
//			RequestDispatcher rd = req.getRequestDispatcher("/log_in.jsp");
//			rd.include(req, resp);
			resp.sendRedirect("/Employee-Management-System/log_in.jsp");

		} catch (Exception e) {
			
			out.print(e);
			
		}

	}

}
