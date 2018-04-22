<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="inserirMeta" method="post">

		Meta : <input type="text" name="meta" /> <input type="submit" value="Gravar" /> <br>
		<form:errors path="meta.meta" cssStyle="color:red"></form:errors>
	</form>

	<a href="voltarMenu">Voltar</a>

</body>
</html>