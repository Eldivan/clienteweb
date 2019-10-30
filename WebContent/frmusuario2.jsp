<!DOCTYPE html>
<%@page import="br.com.curso.entidades.Usuario"  %>
<%@page import="br.com.curso.controller.UsuarioController" %>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de Cadastro de Usario</title>

	<script type="text/javascript">
	
	
	</script>
</head>
<body>
	<%
		Usuario usuario = (Usuario) request.getAttribute("usuario");
	%>
	
	<form  action="usuariocontroller.do" method="post" >
	
	<label>ID: </label>
	 <input type="text" readonly="readonly" name="txtid" value="<%=usuario.getId()%>" size="3" >
	
	<label>Nome: </label>
	 <input type="text" name="txtnome" value="<%=usuario.getNome()%>" size="20" onsubmit="" >
	
	<label>Login: </label>	
	 <input type="text" name="txtlogin" value="<%=usuario.getLogin()%>" size="20" >	
	
	<label>Senha: </label>	
	 <input type="password" name="txtsenha" value="<%=usuario.getSenha()%>" size="6" >
	 
	 <label>IdCargo: </label>	
	 <input type= "text" name ="txtidcargo" value="<%=usuario.getIdCargo()%>" size="3" >	
	
	<input type="submit" value="Salvar" />
	
	</form>
	

</body>
</html>