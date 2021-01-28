package br.com.zup.casadocodigo.cadastropais;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.validation.compartilhada.UniqueValue;

public class PaisRequest {
	
	@NotBlank(message = "{campo.nome.pais}")
	@UniqueValue(domainClass = Pais.class, 
	fieldName = "nome", message = "{unico.nomepais}")
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public Pais transformaObjeto() {
		return new Pais(this.nome);
	}

}
