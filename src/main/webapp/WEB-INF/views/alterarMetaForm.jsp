<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Meta</title>
</head>
<body>

	<form action="alterarMeta" method="post">
	
		<input type="hidden" name="id" />
		Meta : <input type="text" name="meta" value="${meta.meta}" /> <br>
		Autor : <input type="text" name="autorMeta" value="${meta.autorMeta}" /> <br>
		Data Inicio : <input type="text" name="dataInicio" value='<fmt:formatDate value="${meta.dataInicio.time}" pattern="dd/MM/yyyy"/>' /> <br>
		Data Fim : <input type="text" name="dataFim" value='<fmt:formatDate value="${meta.dataFim.time}" pattern="dd/MM/yyyy"/>' /> <br>
		Finalizado? : <input type="checkbox" name="finalizado" value="true" ${meta.finalizado ? 'checked' : ''} /> <br>
		
		<input type="submit" value="Alterar" />
	
	</form>

</body>
</html>