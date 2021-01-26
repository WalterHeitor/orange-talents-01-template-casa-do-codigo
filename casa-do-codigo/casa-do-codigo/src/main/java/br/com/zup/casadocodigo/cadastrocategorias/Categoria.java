package br.com.zup.casadocodigo.cadastrocategorias;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Categoria {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@NotBlank
	@Column(nullable = false, unique = true)
	String nome;
	@Deprecated
	public Categoria() {	}
	
	public Categoria(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}



	
}
