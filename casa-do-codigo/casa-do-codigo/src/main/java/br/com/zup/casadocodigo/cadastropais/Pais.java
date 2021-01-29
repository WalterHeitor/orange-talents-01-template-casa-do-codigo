package br.com.zup.casadocodigo.cadastropais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "{campo.nome.pais}")
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Deprecated
	public Pais () {}
	
	public Pais(@NotBlank(message = "{campo.nome.pais}") String nome) {
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
		return "Pais [id=" + id + ", nome=" + nome + "]";
	}
	
	
}