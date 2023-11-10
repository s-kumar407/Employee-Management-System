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
	
	HttpSession hs=request.getSession();
	
	int oldUserId=(int)hs.getAttribute("oldUserId");
	String oldUserName=(String)hs.getAttribute("oldUserName");
	String oldUserEmail=(String)hs.getAttribute("oldUserEmail");
	String oldUserPassword=(String)hs.getAttribute("oldUserPassword");
	String oldUserGender=(String)hs.getAttribute("oldUserGender");
	String oldUserCity=(String)hs.getAttribute("oldUserCity");

 %>


	<h3>Welcome <%=oldUserName %></h3>

	
	
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
			<td><%=oldUserId%></td>
			<td><%=oldUserName %></td>
			<td><%=oldUserEmail %></td>
			<td><%=oldUserPassword %></td>
			<td><%=oldUserGender %></td>
			<td><%=oldUserCity%></td>
		</tr>

	</table>



</body>
</html>