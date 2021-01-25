package br.com.zup.casadocodigo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zup.casadocodigo.validation.contraintvalidation.EmailUnicoValidador;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailUnicoValidador.class)
public @interface EmailDuplicado {

	String message() default "Email já existente!"; 
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
