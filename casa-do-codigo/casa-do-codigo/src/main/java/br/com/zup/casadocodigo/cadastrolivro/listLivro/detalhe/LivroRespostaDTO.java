package br.com.zup.casadocodigo.cadastrolivro.listLivro.detalhe;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zup.casadocodigo.cadastrolivro.Livro;

public class LivroRespostaDTO {


	private String titulo;

	private String resumo;

	private String sumario;
	
	private BigDecimal preco;

	private int numeroPaginas;

	private String isbn;

	private LocalDate dataPublicacao;

	private Long idCategoria;

	private Long idAutor;

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	

	public LivroRespostaDTO(Livro livro) {
		super();
		this.titulo = livro.getTitulo();		
	}

	

	public LivroRespostaDTO(String titulo, String resumo, String sumario, BigDecimal preco, int numeroPaginas,
			String isbn, LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	public static LivroRespostaDTO transformaEmDTO(Livro livro) {
		return new LivroRespostaDTO(livro.getTitulo(), livro.getResumo(),
				livro.getSumario(), livro.getPreco(), livro.getNumeroPaginas(),
				livro.getIsbn(), livro.getDataPublicacao(), 
				livro.getCategoria().getId(), livro.getAutor().getId());
	}
	
}
