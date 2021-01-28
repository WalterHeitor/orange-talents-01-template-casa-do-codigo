package br.com.zup.casadocodigo.cadastrolivro.listLivro.detalhe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.cadastrolivro.Livro;

@RestController
@RequestMapping("/produtos")
public class DetalheLivroController {
	
	@PersistenceContext
	private EntityManager manage;

	@GetMapping("/{id}")
	public ResponseEntity<DetalheLivroResponse>detalheLivro(@PathVariable("id") Long id){
		Livro livroBuscado = manage.find(Livro.class, id);
		if (livroBuscado == null) {
			return ResponseEntity.notFound().build();
		}
		DetalheLivroResponse detalheLivroResponse =
				new DetalheLivroResponse(livroBuscado);
		return ResponseEntity.ok(detalheLivroResponse);
	}
}
