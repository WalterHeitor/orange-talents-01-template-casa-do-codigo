package br.com.zup.casadocodigo.cadastrolivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.cadastrolivro.listLivro.detalhe.LivroRespostaDTO;

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
}
