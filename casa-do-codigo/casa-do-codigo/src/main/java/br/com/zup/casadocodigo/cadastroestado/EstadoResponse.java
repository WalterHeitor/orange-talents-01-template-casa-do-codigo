package br.com.zup.casadocodigo.cadastroestado;

public class EstadoResponse {
	
	private Long id;
	private String nome;
	
	

	public EstadoResponse(Long id,String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}



	public static EstadoResponse tranformaEmDTO(Estado estado) {
		
		return new EstadoResponse(estado.getId(), estado.getNome());
	}



	public Long getId() {
		return id;
	}



	public String getNome() {
		return nome;
	}

}
