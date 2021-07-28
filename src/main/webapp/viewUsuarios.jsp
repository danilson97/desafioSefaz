
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualização de Usuarios</title>
</head>
<body>
<%@ page import="com.testeS.dao.UsuarioDao, com.testeS.bean.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
 <h1>Listagem de Usuários</h1>
 <%
	List<Usuario> list = UsuarioDao.getAllUsuarios();
	request.setAttribute("list", list);
 %>
 
 <table border="1">
 	<tr>
 		<th>ID</th>
 		<th>Nome</th>
 		<th>Password</th>
 		<th>Email</th>
  		<th>Telefone</th>
  		<th>Editar</th>
  		<th>Excluir</th>
 	</tr>
 	<c:forEach items="${list}" var="usuario">
		<tr>
		<td>${usuario.getId()}</td>
		<td>${usuario.getNome()}</td>
		<td>${usuario.getPassword()}</td>
		<td>${usuario.getEmail()}</td>
		<td>
			<c:forEach items="${usuario.getFones()}" var="fone"> 
				${fone.getFone()} /		
			</c:forEach>
		</td>	
		<td><a href="editForm.jsp?id=${usuario.getId()}">Editar</a></td>
		<td><a href="deleteUsuario.jsp?id=${usuario.getId()}">Excluir</a></td> 	
		</tr>
 	</c:forEach>
 
 </table>
 <br>
 
 
 <form action="addUsuarioForm.jsp" method="post">
	<table>
		<tr>
		<td colspan="2"><input type="submit" value="Adicionar novo Usuário"/></td>
		<td></td>
		</tr>
	</table>
</form>
</body>
</html>