package br.com.zup.casadocodigo.cadastrolivro;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@PersistenceContext
	EntityManager manager;
	
	@Autowired
	LivroRepository livroReposytory;

	@PostMapping
	@Transactional
	public ResponseEntity<LivroRespostaDTO>salvar(@RequestBody @Valid LivroDTO dto){
		
		Livro livro = dto.transformaParaObjeto(manager);
		livroReposytory.save(livro);
		return new ResponseEntity<>(LivroRespostaDTO.transformaEmDTO(livro), HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<ListLivroRespostaDTO>> listar(){
		List<Livro>list = livroReposytory.findAll();
		List<ListLivroRespostaDTO>listDTO = list.stream()
				.map(obj -> new ListLivroRespostaDTO(obj))
				.collect(Collectors.toList());
		return new ResponseEntity<List<ListLivroRespostaDTO>>(listDTO, HttpStatus.OK);
	}
}
