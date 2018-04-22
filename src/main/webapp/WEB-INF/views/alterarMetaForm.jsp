<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Meta</title>
<link
	href="${pageContext.request.contextPath}/webjars/jquery-ui/1.12.1/themes/base/jquery-ui.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/webjars/jquery/3.1.1/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>

</head>
<body>

	<form action="alterarMeta" method="post">

		<input type="hidden" name="id" value="${meta.id}" /> 
		Meta : <input type="text" name="meta" value="${meta.meta}" /> <br> 
		Autor : <input type="text" name="autorMeta" value="${meta.autorMeta}" /> <br>

		<fmt:formatDate value="${meta.dataInicio.time}" pattern="dd/MM/yyyy" var="formatedStartDate" />
		<fmt:formatDate value="${meta.dataFim.time}" pattern="dd/MM/yyyy" var="formatedEndDate" />

		Data Inicio : <tags:campoData id="dataInicio" val="${formatedStartDate}"></tags:campoData> <br> 
		Data Fim : <tags:campoData id="dataFim" val="${formatedEndDate}"></tags:campoData> <br>  <br> 
		Finalizado? : <input type="checkbox" name="finalizado" value="true" ${meta.finalizado ? 'checked' : ''} /> <br> 
		
		<input type="submit" value="Alterar" />

	</form>

</body>
</html>