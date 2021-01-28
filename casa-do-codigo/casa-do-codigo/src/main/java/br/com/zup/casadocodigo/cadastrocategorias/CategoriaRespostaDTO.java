package br.com.zup.casadocodigo.cadastrocategorias;

public class CategoriaRespostaDTO {

	private Long id;
	private String nome;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	 
	public CategoriaRespostaDTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public static CategoriaRespostaDTO transformaEmDTO(Categoria categoria) {
		return new CategoriaRespostaDTO(categoria.getId(), categoria.getNome());
	}
}
