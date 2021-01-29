package br.com.zup.casadocodigo.cadastroestado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.cadastropais.Pais;
import br.com.zup.casadocodigo.validation.compartilhada.UniqueValue;

public class EstadoRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Estado.class, 
	fieldName = "nome", message = "{unico.nomeestado}")
	private String nome;
	@NotNull
	private Long idPais;
	
	
	
	
	public String getNome() {
		return nome;
	}




	public Long getIdPais() {
		return idPais;
	}




	public EstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}




	public Estado transformaParaObjeto(EntityManager manager) {
		@NotNull Pais pais = manager.find(Pais.class, idPais);
		return new Estado(nome, pais);
	}

}
