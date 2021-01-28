package br.com.zup.casadocodigo.cadastropais;

public class PaisResponse {
	
	private Long id;
	private String nome;
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public PaisResponse(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public static PaisResponse transformaEmDTO(Pais pais) {
		return new PaisResponse(pais.getId(), pais.getNome());
	}

}
