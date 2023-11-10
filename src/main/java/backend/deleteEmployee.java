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

@WebServlet("/delete-employee")
public class deleteEmployee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String ID = req.getParameter("ID");
		HttpSession hSession = req.getSession();
		int count = 0;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo", "root", "root");

			ResultSet rSet = (ResultSet) hSession.getAttribute("Total_Employee_Detail");

			while (rSet.next()) {
				
				if (ID.equals(rSet.getString("id"))) 
				{

					PreparedStatement ps = con.prepareStatement("delete from employeedetail where id=(?)");
					ps.setString(1, ID);
					count = ps.executeUpdate();
					PreparedStatement ps2 = con.prepareStatement("select * from employeedetail");
					ResultSet rSet2=ps2.executeQuery();
					hSession.setAttribute("Total_Employee_Detail", rSet2);
					break;
					
				}

			}
			
			if (count > 0) {

				RequestDispatcher rd = req.getRequestDispatcher("/detail_of_employees.jsp");
				rd.forward(req, resp);
			} else {

				RequestDispatcher rd = req.getRequestDispatcher("/delete_employee_detail.jsp");
				rd.forward(req, resp);
			}

		} catch (Exception e) {

			System.out.println(e);

		}

	}

}
