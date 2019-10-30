<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>

</head>
<body>
	
	<c:import url="includes/menu.jsp"></c:import> <br><br>
	
	Seja bem vindo ${sessionScope.usulogado.nome}
	<br>
	<br>
	<img alt="" src="imagens/java 3D.jpg">
	
</body>
</html>