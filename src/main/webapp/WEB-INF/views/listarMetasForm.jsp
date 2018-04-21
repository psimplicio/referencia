<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Metas</title>
</head>
<body>

	<a href="voltarMenu">Voltar</a>
	
	<table>
		<tr>
			<th>Meta</th>
			<th>Status</th>
			<th>Data Inicio</th>
			<th>Data Fim</th>
			<th>Alterar</th>
			<th>Remover</th>
		</tr>
		<c:forEach items="${metas}" var="meta">

			<tr>
			
				<td>${meta.meta}</td>  
				<c:if test="${empty meta.dataInicio}">
					<td><a href="iniciarMeta">Iniciar</a></td>	
				</c:if>
				<c:if test="${not empty meta.dataInicio && meta.finalizado eq false}">
					<td><a href="finalizarMeta">Finalizar</a></td>
				</c:if>
				
				<td><fmt:formatDate value="${meta.dataInicio.time}" pattern="dd/MM/yyyy"/> </td>
				<td>${meta.dataFim}</td>
				<td><a href="alterarMetaForm?id=${meta.id}">Alterar</a>
				<td><a href="removerMeta?id=${meta.id}">Remover</a>
				
			</tr>
		
		</c:forEach>
		
	</table>

</body>
</html>