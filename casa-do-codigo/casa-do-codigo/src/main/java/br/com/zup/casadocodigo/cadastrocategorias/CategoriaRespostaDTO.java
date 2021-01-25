package br.com.zup.casadocodigo.cadastrocategorias;

public class CategoriaRespostaDTO {

	String nome;
	
	public String getNome() {
		return nome;
	}

	public CategoriaRespostaDTO(String nome) {
		super();
		this.nome = nome;
	}
	 
	public static CategoriaRespostaDTO transformaEmDTO(Categoria categoria) {
		return new CategoriaRespostaDTO(categoria.nome);
	}
}
