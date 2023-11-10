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
HttpSession hs= request.getSession();
int newUserId=(int)hs.getAttribute("newUserId");
String newUserName=(String)hs.getAttribute("newUserName");
String newUserEmail=(String)hs.getAttribute("newUserEmail");
String newUserPassword=(String)hs.getAttribute("newUserPassword");
String newUserGender=(String)hs.getAttribute("newUserGender");
String newUserCity=(String)hs.getAttribute("newUserCity");
%>
<h3>Welcome <%=newUserName%></h3>
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
<td><%=newUserId %></td>
<td><%=newUserName %></td>
<td><%=newUserEmail %></td>
<td><%=newUserPassword %></td>
<td><%=newUserGender %></td>
<td><%=newUserCity %></td>

</tr>



</table>



</body>
</html>