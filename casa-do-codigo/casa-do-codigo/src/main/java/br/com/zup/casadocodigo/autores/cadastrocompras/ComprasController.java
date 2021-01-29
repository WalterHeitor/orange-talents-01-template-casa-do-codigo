package br.com.zup.casadocodigo.autores.cadastrocompras;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class ComprasController {

	@Autowired
	private EstadoPertenceAPaisValidador estadoPertenceAPaisValidador;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new VerificaDocumentoCpfCnpjValidador(),estadoPertenceAPaisValidador);
	}

	@PostMapping
	public String salvar(@RequestBody @Valid CompraRequest compraRequest) {
		return compraRequest.toString();
	}
}
