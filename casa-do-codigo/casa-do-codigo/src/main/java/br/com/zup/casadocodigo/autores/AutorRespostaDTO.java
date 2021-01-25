package br.com.zup.casadocodigo.autores;

import java.time.LocalDateTime;

public class AutorRespostaDTO {

	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime dataCriacao;

	public AutorRespostaDTO(String nome, String email, String descricao, LocalDateTime dataCriacao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static AutorRespostaDTO transformaEmDTO(Autor autor) {
		return new AutorRespostaDTO(autor.getNome(), autor.getEmail(),
				autor.getDescricao(), autor.getDataCriacao());
	}
}
