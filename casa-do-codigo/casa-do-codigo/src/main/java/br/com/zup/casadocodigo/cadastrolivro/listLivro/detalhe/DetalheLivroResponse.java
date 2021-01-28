package br.com.zup.casadocodigo.cadastrolivro.listLivro.detalhe;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zup.casadocodigo.cadastrolivro.Livro;

public class DetalheLivroResponse {

	private String titulo;
	private String nomeAutor;
	private String autorDescricao;
	private String isbn;
	private int numeroPaginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private String dataPublicacao;
	
	

	public DetalheLivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.nomeAutor = livro.getAutor().getNome();
		this.autorDescricao = livro.getAutor().getDescricao();
		this.isbn = livro.getIsbn();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.preco = livro.getPreco();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();	
		this.dataPublicacao = livro.getDataPublicacao()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public String getTitulo() {
		return titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getAutorDescricao() {
		return autorDescricao;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}
	
	public String getDataPublicacao() {
		return dataPublicacao;
	}
	

}
