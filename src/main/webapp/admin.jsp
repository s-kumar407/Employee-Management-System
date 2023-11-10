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

	int adminId = (int) hs.getAttribute("adminId");
	String adminName = (String) hs.getAttribute("adminName");
	String adminEmail = (String) hs.getAttribute("adminEmail");
	String adminPassword = (String) hs.getAttribute("adminPassword");
	String adminGender = (String) hs.getAttribute("adminGender");
	String adminCity = (String) hs.getAttribute("adminCity");
	%>
	
	<h3>Welcome <%=adminName%><h3 />

		<table border="8">

			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Gender</th>
				<th>City</th>
			</tr>
			<tr>
				<td><%=adminId%></td>
				<td><%=adminName%></td>
				<td><%=adminEmail%></td>
				<td><%=adminPassword%></td>
				<td><%=adminGender%></td>
				<td><%=adminCity%></td>

			</tr>



		</table><br/><br/>
		
		<h1>What Do You Want?</h1>
		
		See Total Employee : <a href="detail_of_employees.jsp">Yes</a><br/><br/>
		Delete Any Employee Detail : <a href="delete_employee_detail.jsp">Yes</a><br/><br/>
		Update any Employee Detail : <a href="update_employee_detail.jsp">Yes</a><br/><br/>
</body>
</html>