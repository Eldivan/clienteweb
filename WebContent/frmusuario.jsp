<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Formulario de Cadastro de Usario com EL</title>

	<script type="text/javascript">
	
	
	</script>
</head>
<body>

	<c:import url="includes/menu.jsp"></c:import> <br><br>
	
	<form  action="usuariocontroller.do" method="post" >
	
	<label>ID: </label>
	 <input type="text" readonly="readonly" name="txtid" value="${usuario.id}" size="3" >
	
	<label>Nome: </label>
	 <input type="text" name="txtnome" value="${usuario.nome}" size="20" onsubmit="" >
	
	<label>Login: </label>	
	 <input type="text" name="txtlogin" value="${usuario.login}" size="20" >	
	
	<label>Senha: </label>	
	 <input type="password" name="txtsenha" value="${usuario.senha}" size="6" >
	 
	 <label>IdCargo: </label>	
	 <input type= "text" name ="txtidcargo" value="${usuario.idCargo}" size="3" >	
	
	<input type="submit" value="Salvar" />
	
	</form>
	
</body>
</html>