package br.com.zup.casadocodigo.cadastrocategorias;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.validation.compartilhada.UniqueValue;

public class CategoriaDTO {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, 
	fieldName = "nome", message = "{campo.nome.categoria}")
	String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria transformaParaObjeto() {
		return new  Categoria(this.nome);
	}

}
