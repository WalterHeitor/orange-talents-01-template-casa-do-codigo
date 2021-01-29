package br.com.zup.casadocodigo.autores.cadastrocompras;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VerificaDocumentoCpfCnpjValidador implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return CompraRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("passou direto");
			return ;
		}
		CompraRequest request =  (CompraRequest) target;
		System.out.println("antes doif");
		if(!request.documentoValido()) {
			System.out.println("caiu no if");
			errors.reject("documento",null ,"O documento prescisa ser cpf ou cnpj");
		}
		
	}

}
