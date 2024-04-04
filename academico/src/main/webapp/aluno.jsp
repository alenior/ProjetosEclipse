<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Detalhes do Aluno</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h2>Detalhes do Aluno</h2>
	<p>
		Matrícula:
		<%=request.getParameter("matricula")%></p>
	<p>
		Nome:
		<%=request.getParameter("nome")%></p>
	<p>
		Média:
		<%=request.getParameter("media")%></p>
	<p>
		Frequência:
		<%=request.getParameter("frequencia")%></p>
</body>
</html>