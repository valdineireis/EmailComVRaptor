package br.com.valdineireis.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.valdineireis.util.Email;

@Resource
public class IndexController {

	private final Result result;
	private final Validator validator;

	public IndexController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}
	
	@Path("/")
	public void index() {
	}
	
	@Path("/verifique-os-campos")
	public void index(String para, String assunto, String mensagem) {
		result
			.include("para", para)
			.include("assunto", assunto)
			.include("mensagem", mensagem);
	}
	
	@Post
	public void enviar(String para, String assunto, String mensagem) {
		
		if (para == null || para.isEmpty())
            validator.add(new ValidationMessage("Informe o destinatário.", "email"));
		if (assunto == null || assunto.isEmpty())
            validator.add(new ValidationMessage("Informe o assunto.", "email"));
		if (mensagem == null || mensagem.isEmpty())
            validator.add(new ValidationMessage("Informe a mensagem.", "email"));
		
		validator.onErrorRedirectTo(this).index(para, assunto, mensagem);
		
		try {
			Email.enviar(para, assunto, mensagem);
			result.include("message", "E-mail enviado com sucesso.");
		} catch (Exception e) {
			result.include("error", e.getMessage());
		}
		
		result.redirectTo(this).index();
	}

}
