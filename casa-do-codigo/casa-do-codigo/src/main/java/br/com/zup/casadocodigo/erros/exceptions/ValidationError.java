package br.com.zup.casadocodigo.erros.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError {
	
	private List<FieldMensage> errors = new ArrayList<>();

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(long timestamp, Integer status, String error) {
		super(timestamp, status, error);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMensage> getErrors() {
		return errors;
	}

	public void addErrors(String fielName, String message) {
		this.errors.add(new FieldMensage(fielName, message));
	}
	

}
