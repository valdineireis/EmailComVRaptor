<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exemplo de Envio de E-mail com VRaptor</title>
<link href="<c:url value='/css/estilo.css'/>" type="text/css" rel="stylesheet"/>
</head>
<body>

<div id='conteudo'>

	<form action="${linkTo[IndexController].enviar}" name="Contato" method="post" id="formContato">
		<fieldset>
			<legend>Enviar e-mail</legend>
			
			<div id="erros">
			    <c:forEach items="${errors}" var="error">
			        ${error.message}<br/>
			    </c:forEach>
			    <c:if test="${not empty message}">
			    	${message}
			    </c:if>
			    <c:if test="${not empty error}">
			    	${error}
			    </c:if>
			</div>
			
			<p>
				<label for='nome'>Destinatário: </label>
				<input type='text' id='para' name='para' tabindex=1 value="${para}">
			</p>
			<p>
				<label for='email'>Assunto: </label>
				<input type='text' id='assunto' name='assunto' tabindex=2 value="${assunto}">
			</p>
			<p>
				<label for='mensagem'>Mensagem: </label>
				<textarea row='' col='' id='mensagem' name='mensagem' tabindex=3>${mensagem}</textarea>
			</p>
			<p id='botoes'>
				<input type='submit' value='Enviar' tabindex=4>
				<input type='reset' value='Limpar' tabindex=5>
			</p>

		</fieldset>
	</form>

</div>

<script type='text/javascript'>
	function focus() {
		document.getElementById('para').focus();
		document.getElementById('para').select;
	}
	focus();
</script>

</body>
</html>