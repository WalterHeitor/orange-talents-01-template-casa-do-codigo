package br.com.zup.casadocodigo.autores.cadastrocompras;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import br.com.zup.casadocodigo.cadastroestado.Estado;
import br.com.zup.casadocodigo.cadastropais.Pais;
import br.com.zup.casadocodigo.validation.compartilhada.CPFouCNPJ;
import br.com.zup.casadocodigo.validation.compartilhada.ExistId;

public class CompraRequest {
	
	@NotBlank 
	@Email
	private String email;
	@NotBlank 
	private String nome;
	@NotBlank 
	private String sobrenome;
	@NotBlank 
	//@CPFouCNPJ
	private String documento;
	@NotBlank 
	private String endereco;
	@NotBlank 
	private String complemento;
	@NotBlank 
	private String cidade;
	@NotNull
	@ExistId(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;
	@NotNull
	@ExistId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	@NotBlank 
	private String telefone;
	@NotBlank 
	private String cep;
	public CompraRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idEstado, @NotNull Long idPais, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idEstado = idEstado;
		this.idPais = idPais;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Long getIdPais() {
		return idPais;
	}
	public Long getIdEstado() {
		return idEstado;
	}
	
	public String getDocumento() {
		return documento;
	}
	
	@Override
	public String toString() {
		return "CompraRequest [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", idEstado=" + idEstado + ", idPais=" + idPais + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

	public boolean documentoValido() {
		Assert.hasLength(documento, "Você não deveria validar o documento se não tiver sido peenchido!");
		
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);
		
		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);
				
		return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);
	}
	
	

}
