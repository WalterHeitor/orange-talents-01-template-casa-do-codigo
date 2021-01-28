package br.com.zup.casadocodigo.cadastrolivro.listLivro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.cadastrolivro.LivroRepository;

@RestController
@RequestMapping("/livros")
public class ListaLivroController {
	
	@Autowired
	LivroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<LivroResposta>>lista(){	
		List<LivroResposta> list = repository.findbuscarLivrosSQL();
		return new ResponseEntity<List<LivroResposta>>(list, HttpStatus.OK);
		
	}

}
