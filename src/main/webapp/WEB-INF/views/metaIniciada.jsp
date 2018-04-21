<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<td>${meta.meta}</td>
<td>${meta.autorMeta}</td>
<td><a href="#" onclick="finalizarMeta(${meta.id})">Finalizar</a></td>
<td><fmt:formatDate value="${meta.dataInicio.time}"
		pattern="dd/MM/yyyy" /></td>
<td><fmt:formatDate value="${meta.dataFim.time}"
		pattern="dd/MM/yyyy" /></td>
<td><a href="alterarMetaForm?id=${meta.id}">Altera</a></td>
<td><a href="removerMeta?id=${meta.id}">Remover</a></td>