package br.com.zup.casadocodigo.cadastropais;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {
	
	@Autowired
	private PaisRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<PaisResponse>salvar(@RequestBody @Valid PaisRequest paisRequest){
		Pais pais = paisRequest.transformaObjeto();
		repository.save(pais);
		return new  ResponseEntity<>(PaisResponse.transformaEmDTO(pais),HttpStatus.OK);
	}
}
