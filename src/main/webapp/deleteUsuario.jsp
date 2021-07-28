<%@ page import="com.testeS.dao.UsuarioDao"%>
<jsp:useBean id="u" class="com.testeS.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<% 
UsuarioDao.deletarUsuario(u);
response.sendRedirect("viewUsuarios.jsp");
%>