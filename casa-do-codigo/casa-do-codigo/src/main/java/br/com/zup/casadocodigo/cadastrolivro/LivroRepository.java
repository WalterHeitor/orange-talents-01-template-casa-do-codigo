package br.com.zup.casadocodigo.cadastrolivro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.zup.casadocodigo.cadastrolivro.listLivro.LivroResposta;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	
	//@Query(" SELECT new br.com.zup.casadocodigo.cadastrolivro.listLivro.LivroResposta() FROM Livro l")
	@Query("SELECT l.id, l.titulo FROM Livro l")
	List<LivroResposta> findbuscarLivros();

	@Query(value =" SELECT l.id, l.titulo FROM Livro l", nativeQuery = true)
	List<LivroResposta> findbuscarLivrosSQL();
	
	
}
