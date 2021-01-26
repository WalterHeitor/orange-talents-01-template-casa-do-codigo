package br.com.zup.casadocodigo.cadastrolivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casadocodigo.autores.Autor;
import br.com.zup.casadocodigo.cadastrocategorias.Categoria;

public class LivroDTO {
	
	@NotBlank
	private String titulo;
	@NotBlank
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull
	@Min(value = 20)
	private BigDecimal preco;
	@Min(value = 20)
	private int numeroPaginas;
	@NotBlank
	private String isbn;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	private Long idCategoria;
	@NotNull
	private Long idAutor;
	
	public LivroDTO() {
		// TODO Auto-generated constructor stub
	}

	public LivroDTO(@NotBlank String titulo, @NotBlank String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(20) int numeroPaginas, @NotBlank String isbn,
			@Future LocalDate dataPublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
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
	/*
	 * Este setter foi criado por que o json na e capaz
	 *  de dessearilizar  a data pelo parametro do construtor.
	 */
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public Livro transformaParaObjeto() {
		return new Livro(this.titulo, this.resumo, this.sumario, this.preco,
				this.numeroPaginas, this.isbn, this.dataPublicacao);
	}
	
	public Livro transformaParaObjeto(EntityManager entityManager) {
		@NotNull Autor autor = entityManager.find(Autor.class, idAutor);
		@NotNull Categoria categoria = entityManager.find(Categoria.class, idCategoria);
		
		Assert.state(autor != null , "Você esta querendo cadastrar um livro ");
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao);
	}
	
	
	
}
