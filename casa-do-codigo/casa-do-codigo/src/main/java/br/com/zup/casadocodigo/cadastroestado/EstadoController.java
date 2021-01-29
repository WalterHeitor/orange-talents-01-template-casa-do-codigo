package br.com.zup.casadocodigo.cadastroestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@PersistenceContext
	EntityManager manager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstadoResponse>salvar(@RequestBody EstadoRequest estadoRequest){
		Estado estado = estadoRequest.transformaParaObjeto(manager);
		manager.persist(estado);
		return new ResponseEntity<EstadoResponse>(EstadoResponse.tranformaEmDTO(estado), HttpStatus.OK);
	}

}
