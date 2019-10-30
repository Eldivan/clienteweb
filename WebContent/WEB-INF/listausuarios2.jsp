<%@page import="br.com.curso.entidades.Usuario" %>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de usuarios</title>

</head>
<body>
	<table border="1">
		<tr bgcolor="#ccccccc">
			<th>ID </th><th>Nome </th><th>Login </th><th>senha</th><th>Id_cargo </th><th>Acao</th>
		</tr>
<% 
	List<Usuario>lista = (List<Usuario>)request.getAttribute("lista");
	for(Usuario usu : lista){
%>	
		<tr>
			<td><%=usu.getId()%></td>
			<td><% out.print(usu.getNome()); %></td>
			<td><%=usu.getLogin()%></td>
			<td><%=usu.getSenha()%></td>
			<td><%=usu.getIdCargo()%>
			<td>
			<a href="usuariocontroller.do?acao=exc&id=<%=usu.getId()%>"> Excluir </a> 
			|
			<a href="usuariocontroller.do?acao=alt&id=<%=usu.getId()%>"> Alterar</a>
			</td>
		</td>
<%
}
%>
	</table>
</body>
</html>