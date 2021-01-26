package br.com.zup.casadocodigo.cadastrolivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casadocodigo.autores.Autor;
import br.com.zup.casadocodigo.cadastrocategorias.Categoria;
@Entity
public class Livro {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;	
	@Column(nullable = false, unique = true)
	private @NotBlank String titulo;
	@NotBlank
	@Column(nullable = false)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull
	@Min(value = 20)
	@Column(nullable = false)
	private BigDecimal preco;
	@Min(value = 20)
	private int numeroPaginas;
	@NotBlank
	@Column(nullable = false, unique = true)
	private String isbn;
	@Future @NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@ManyToOne
	private @NotNull @Valid Autor autor;
	@ManyToOne
	private @NotNull @Valid Categoria categoria;
		
	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Livro(@NotBlank String titulo, @NotBlank String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(20) int numeroPaginas, @NotBlank String isbn,
			@Future @NotNull LocalDate dataPublicacao, @NotNull @Valid Autor autor,
			@NotNull @Valid Categoria categoria) {
		super();		
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
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

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	
	
}
