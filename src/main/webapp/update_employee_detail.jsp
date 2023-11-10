<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Detail Updated</h1>
<form action="update-employee" method="post">
Enter Employee's ID : <input type="number" name="ID"/><br/><br/>
Enter Employee's Updated Name : <input type="text" name="updatedName"/><br/><br/>
Enter Employee's Updated Email : <input type="text" name="updatedEmail"/><br/><br/>
Enter Employee's Updated Password : <input type="text" name="updatedPassword"/><br/><br/>
Enter Employee's Updated Gender : <input type="text" name="updatedGender"/><br/><br/>
Enter Employee's Updated City : <input type="text" name="updatedCity"/><br/><br/>
<input type="submit" value="Update"/>
</form>
</body>
</html>