<%@ page import="com.testeS.dao.UsuarioDao"%>
<jsp:useBean id="u" class="com.testeS.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
<%
int i = UsuarioDao.updateUsuario(u);
response.sendRedirect("viewUsuarios.jsp");
%>