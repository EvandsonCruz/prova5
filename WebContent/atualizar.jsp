<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="atualizarCliente" method="post">
		Id:<br>
		<input type="text" name="id" value=<%= request.getParameter("id") %> readonly="readonly"><br><br>
		Nome:<br>
		<input type="text" name="nome" value=<%= request.getParameter("nome") %>><br><br>
		Email:<br>
		<input type="text" name="email" value=<%= request.getParameter("email") %>><br><br>
		
		<input type="submit" name="atualizar" value="Atualizar"><br><br>
	
	</form>
</body>
</html>