package backend;

import java.io.IOException;
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

@WebServlet("/update-employee")
public class updateEmployee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String employeeId = req.getParameter("ID");
			String updatedName = req.getParameter("updatedName");
			String updatedEmail = req.getParameter("updatedEmail");
			String updatedPassword = req.getParameter("updatedPassword");
			String updatedGender = req.getParameter("updatedGender");
			String updatedCity = req.getParameter("updatedCity");

			System.out.println(updatedName);
			System.out.println(updatedEmail);
			System.out.println(updatedPassword);
			System.out.println(updatedGender);
			System.out.println(updatedCity);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo", "root", "root");

			HttpSession hSession = req.getSession();
			ResultSet rSet = (ResultSet) hSession.getAttribute("Total_Employee_Detail");

			while (rSet.next()) {
				if (employeeId.equals(rSet.getString("id"))) {

					if (updatedName!= null && !updatedName.isEmpty()) {
						PreparedStatement ps = con.prepareStatement("update employeedetail set name=(?) where id=(?)");
						ps.setString(1, updatedName);
						ps.setString(2, employeeId);
						int updateCount = ps.executeUpdate();
					}
					if (updatedEmail!= null && !updatedEmail.isEmpty()) {
						PreparedStatement ps = con.prepareStatement("update employeedetail set email=(?) where id=(?)");
						ps.setString(1, updatedEmail);
						ps.setString(2, employeeId);
						int updateCount = ps.executeUpdate();
					}
					if (updatedPassword != null && !updatedPassword.isEmpty()) {
						PreparedStatement ps = con
								.prepareStatement("update employeedetail set password=(?) where id=(?)");
						ps.setString(1,updatedPassword);
						ps.setString(2, employeeId);
						int updateCount = ps.executeUpdate();
					}
					if (updatedGender!= null && !updatedGender.isEmpty()) {
						PreparedStatement ps = con
								.prepareStatement("update employeedetail set gender=(?) where id=(?)");
						ps.setString(1,updatedGender);
						ps.setString(2, employeeId);
						int updateCount = ps.executeUpdate();
					}

					if (updatedCity != null && !updatedCity.isEmpty()) {
						PreparedStatement ps = con.prepareStatement("update employeedetail set city=(?) where id=(?)");
						ps.setString(1,updatedCity);
						ps.setString(2, employeeId);
						int updateCount = ps.executeUpdate();
					}
					
					PreparedStatement ps = con.prepareStatement("select * from employeedetail");
					ResultSet rSet2=ps.executeQuery();
					hSession.setAttribute("Total_Employee_Detail", rSet2);
					
					RequestDispatcher rd = req.getRequestDispatcher("/detail_of_employees.jsp");
					rd.forward(req, resp);
					return;
					
				}
				
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("/update_employee_detail.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {

			System.out.println(e);

		}

	}

}
