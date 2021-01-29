package br.com.zup.casadocodigo.cadastroestado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.cadastropais.Pais;

@Entity
public class Estado {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nome;
	@ManyToOne
	@NotNull @Valid
	@JoinColumn(name = "pais_id", nullable = false)
	private Pais pais;
	public Estado(String nome, @NotNull @Valid Pais pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Pais getPais() {
		return pais;
	}
	
	
	
}
