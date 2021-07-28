<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="com.testeS.bean.Usuario, com.testeS.dao.UsuarioDao"%>

	<%
	int id = Integer.parseInt(request.getParameter("id"));
	Usuario usuario = UsuarioDao.getRegistroById(id);
	%>


	<h1>Edição do Usuário</h1>
	
	<form action="update " method="post">
		<input type="hiden" name="id" value="<%=usuario.getId()%>"/>
		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" value="<%=usuario.getNome()%>"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password" value="<%=usuario.getPassword()%>"/></td>
			</tr> 
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="<%=usuario.getEmail()%>"/></td>
			</tr>
			<tr>
			<td colspan="2"><input type="submit" value="Editar Usuário"/></td>
			<td></td>
			</tr>
		</table>
		
	</form>
	


</body>
</html>