package br.com.zup.casadocodigo.cadastrolivro;

public class ListLivroRespostaDTO {
	
	private Long id;
	private String titulo;
	
	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public ListLivroRespostaDTO(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}
	
	public ListLivroRespostaDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	
	

}
