<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="employee_detail" method="post">

Name:<input type="text" name="name" required/><br/><br/>
Email:<input type="text" name="email" required/><br/><br/>
Password:<input type="password" name="password" required/><br/><br/>
Gender:<input type="radio" name="gender" value="male" required/>Male<input type="radio" name="gender" value="female" required/>Female<br/><br/>
City:<input type="text" name="city" required/><br/><br/>
<input type="submit" value="Register"/><br/><br/>
Already have an account? <a href="log_in.jsp">Log_In</a><br/><br/>
<a href="admin_log_in.jsp">Admin Log_In</a>


</form>
</body>
</html>