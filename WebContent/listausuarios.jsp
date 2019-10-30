<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de usuarios jstl</title>

<script type="text/javascript">
function confirmaExclusao(id) {
	if(window.confirm("Tem certeza que deseja excluir o registro"+id)){
	location.href="usuariocontroller.do?acao=exc&id="+id; 	
	}	
}
 
</script>

</head>
<body>

	<c:import url="includes/menu.jsp"></c:import> <br><br>
	
	<table border="1">
		<tr bgcolor="#ccccccc">
			<th>ID </th><th>Nome </th><th>Login </th><th>senha</th><th>Id_cargo </th><th colspan="2">Acao</th>
		</tr>

	<c:forEach items="${requestScope.lista}" var="usu">
		<tr>
			<td>${usu.id}</td>
			<td>${usu.nome}</td>
			<td>${usu.login}</td>
			<td>${usu.senha}</td>
			<td>${usu.idCargo}</td>
			<td>
			<a href="javascript:confirmaExclusao(${usu.id})"> Excluir </a> 
			|
			<a href="usuariocontroller.do?acao=alt&id=${usu.id}"> Alterar</a>
			</td>
		</td>
	</c:forEach>
	</table>
</body>
</html>