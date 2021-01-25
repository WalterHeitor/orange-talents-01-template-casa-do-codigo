package br.com.zup.casadocodigo.cadastrocategorias;


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
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaRespostaDTO> salvar(@RequestBody @Valid CategoriaDTO dto){
		Categoria categoria = dto.transformaParaObjeto();
		categoriaRepository.save(categoria);
		return new ResponseEntity<>(CategoriaRespostaDTO.transformaEmDTO(categoria),HttpStatus.OK);
	}
	

}
