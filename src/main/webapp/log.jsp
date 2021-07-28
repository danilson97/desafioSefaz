<%@ page import="com.testeS.dao.UsuarioDao"%>
<jsp:useBean id="u" class="com.testeS.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
<%
int i = UsuarioDao.login(u);
if(i == 1){
	response.sendRedirect("viewUsuarios.jsp");
}else{
	response.sendRedirect("login.jsp");
}
%>