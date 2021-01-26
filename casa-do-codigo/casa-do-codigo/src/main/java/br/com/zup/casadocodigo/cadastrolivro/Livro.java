package br.com.zup.casadocodigo.cadastrolivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casadocodigo.autores.Autor;
import br.com.zup.casadocodigo.cadastrocategorias.Categoria;
//@Entity
public class Livro {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;	
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
	
	private Categoria categoria;
	
	private Autor autor;
	
	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Livro(@NotBlank String titulo, @NotBlank String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(20) int numeroPaginas, @NotBlank String isbn,
			@Future LocalDate dataPublicacao) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
	}
	
	
	
}
