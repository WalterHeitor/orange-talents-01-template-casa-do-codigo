package br.com.zup.casadocodigo.erros.compartilhados;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsOutputDto {
    private List<String> globalErrorsMenssages = new ArrayList<>();
    private List<FieldErrorOutputDto>fieldErrors = new ArrayList<>();

    public void addError(String message){
        globalErrorsMenssages.add(message);
    }
    public void addFieldError(String field, String message){
        FieldErrorOutputDto fieldError = new FieldErrorOutputDto(field, message);
        fieldErrors.add(fieldError);
    }

    public List<String> getGlobalErrorsMenssages() {
        return globalErrorsMenssages;
    }

    public List<FieldErrorOutputDto> getErrors() {
        return fieldErrors;
    }
}
