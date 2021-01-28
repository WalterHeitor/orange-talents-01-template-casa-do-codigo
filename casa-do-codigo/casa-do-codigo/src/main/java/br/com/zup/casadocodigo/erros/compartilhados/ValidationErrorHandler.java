package br.com.zup.casadocodigo.erros.compartilhados;

import java.lang.reflect.Field;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zup.casadocodigo.erros.exceptions.StandartError;
import br.com.zup.casadocodigo.erros.exceptions.ValidationError;
//@RestControllerAdvice
public class ValidationErrorHandler {
    @Autowired
    private MessageSource messageSource;


    public ValidationErrorHandler() {
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorsOutputDto handlerValidatioError(MethodArgumentNotValidException exception){
        List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        return buildValidationErrors(globalErrors, fieldErrors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ValidationErrorsOutputDto handlerValidatioError(BindException exception){
        List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        return buildValidationErrors(globalErrors, fieldErrors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<StandartError> illegalStateExceptionHandler
    (SQLIntegrityConstraintViolationException exception,
    		ServletRequest request) throws NoSuchFieldException, SecurityException{
  	ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
  			"Erro de Validação nos campos");
  	
    	
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

    private ValidationErrorsOutputDto buildValidationErrors(List<ObjectError>globalErrors,
                                                            List<FieldError>fieldErrors){
        ValidationErrorsOutputDto validationErrors = new ValidationErrorsOutputDto();
        globalErrors.forEach(objectError -> validationErrors.addError(getErrorMessage(objectError)));
        fieldErrors.forEach(error -> {
            String errorMessage = getErrorMessage(error);
            validationErrors.addFieldError(error.getField(), errorMessage);
        });
        return validationErrors;
    }
    private String getErrorMessage(ObjectError error){
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }
}
