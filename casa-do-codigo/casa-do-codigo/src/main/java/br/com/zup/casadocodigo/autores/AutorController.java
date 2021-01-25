package br.com.zup.casadocodigo.autores;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//carga intricica = 4
@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@PersistenceContext
	private EntityManager manager;

	/**
	 * @param dto
	 * @return
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<AutorRespostaDTO> salvar(@RequestBody @Valid AutorDTO dto) {
		Autor autor = dto.transformaParaObjeto();
		autorRepository.save(autor);
		return new ResponseEntity<>(AutorRespostaDTO.transformaEmDTO(autor), HttpStatus.OK);
	}

}
