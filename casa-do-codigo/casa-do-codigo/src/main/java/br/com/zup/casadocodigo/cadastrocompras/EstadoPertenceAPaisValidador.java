package br.com.zup.casadocodigo.cadastrocompras;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.cadastroestado.Estado;
import br.com.zup.casadocodigo.cadastropais.Pais;

@Component
public class EstadoPertenceAPaisValidador implements Validator{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean supports(Class<?> clazz) {
		return CompraRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		CompraRequest request = (CompraRequest) target;
		
		Pais pais = entityManager.find(Pais.class, request.getIdPais());
		Estado estado = entityManager.find(Estado.class, request.getIdEstado());
		
		if(!estado.pertenceAPais(pais)) {
			errors.reject("idEstado", null, "Este Estado não pertence ao pais selecionado");
		}
		
		
	}

}
