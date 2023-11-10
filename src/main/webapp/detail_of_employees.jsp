<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	HttpSession hs = request.getSession();
	ResultSet rs = (ResultSet) hs.getAttribute("Total_Employee_Detail");
	System.out.println(rs);

	%>
	<h1>Detail Of Employees</h1>
	<table border="8">

		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Gender</th>
			<th>City</th>
		</tr>
		<%
		if(rs!=null){
		while (rs.next()) {
			int employeeId=rs.getInt("id");
			String employeeName=rs.getString("name");
			String employeeEmail=rs.getString("email");
			String employeePassword=rs.getString("password");
			String employeeGender=rs.getString("gender");
			String employeeCity=rs.getString("city");
		%>

		<tr>
			<td>
				<%=
				employeeId
				%>
			</td>
			<td>
				<%=
				employeeName
				%>
			</td>
			<td>
				<%=
				employeeEmail
				%>
			</td>
			<td>
				<%=
				employeePassword
				%>
			</td>
			<td>
				<%=
				employeeGender
				%>
			</td>
			<td>
				<%=
		     	employeeCity
				%>
			</td>

		</tr>


		<%
		}
		}else{
			
			System.out.println("Result Set Is Empty");
	      }
		
		%>




	</table>



</body>
</html>