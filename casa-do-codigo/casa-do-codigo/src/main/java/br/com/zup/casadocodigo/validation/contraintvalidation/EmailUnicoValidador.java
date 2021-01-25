package br.com.zup.casadocodigo.validation.contraintvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zup.casadocodigo.validation.EmailDuplicado;



public class EmailUnicoValidador implements ConstraintValidator<EmailDuplicado, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return false;
	}
	
	@Override
	public void initialize(EmailDuplicado constraintAnnotation) {
		// TODO Auto-generated method stub
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	

}
