<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<body>

	<h3>Resultado da busca2:</h3>

	<ul>

		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.id}:${empresa.nome}</li>
		</c:forEach>

	</ul>


</body>
</html>