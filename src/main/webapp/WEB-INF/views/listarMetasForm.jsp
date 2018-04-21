<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Metas</title>
<link href="${pageContext.request.contextPath}/webjars/jquery-ui/1.12.1/themes/base/jquery-ui.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>

</head>
<body>

	<script>
		
		function finalizarMeta(id){
			
			$.post("finalizarAgora", {"id" : id}, function(resposta){
				
				$("#meta_" + id).html(resposta);
				
			});
		}
		
		function iniciarMeta(id){
			
			$.post("iniciarAgora", {"id" : id}, function(resposta){
				
				$("#meta_" + id).html(resposta);
				
			})
			
		}
	
	</script>

	<a href="voltarMenu">Voltar</a>
	
	<table>
		<tr>
			<th>Meta</th>
			<th>Autor</th>
			<th>Status</th>
			<th>Data Inicio</th>
			<th>Data Fim</th>
			<th>Alterar</th>
			<th>Remover</th>
		</tr>
		<c:forEach items="${metas}" var="meta">

			<tr id="meta_${meta.id}">
			
				<td>${meta.meta}</td>  
				<td>${meta.autorMeta}</td>
				<c:if test="${empty meta.dataInicio}">
					<td><a href="#" onclick="iniciarMeta(${meta.id})">Iniciar</a></td>	
				</c:if>
				<c:if test="${not empty meta.dataInicio && meta.finalizado eq false}">
					<td><a href="#" onclick="finalizarMeta(${meta.id})">Finalizar</a></td>
				</c:if>
				<c:if test="${meta.finalizado eq true}">
					<td><b>Finalizado</b></td>
				</c:if>
				
				<td><fmt:formatDate value="${meta.dataInicio.time}" pattern="dd/MM/yyyy"/> </td>
				<td><fmt:formatDate value="${meta.dataFim.time}" pattern="dd/MM/yyyy"/></td>
				<td><a href="alterarMetaForm?id=${meta.id}">Alterar</a>
				<td><a href="removerMeta?id=${meta.id}">Remover</a>
				
			</tr>
		
		</c:forEach>
		
	</table>

</body>
</html>