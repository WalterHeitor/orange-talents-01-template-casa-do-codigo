package br.com.zup.casadocodigo.erros.exceptions;

public class FieldMensage {

	private String fielName;
	private String message;
	public FieldMensage() {	}
	public FieldMensage(String fielName, String message) {
		super();
		this.fielName = fielName;
		this.message = message;
	}
	public String getFielName() {
		return fielName;
	}
	public String getMessage() {
		return message;
	}
	public void setFielName(String fielName) {
		this.fielName = fielName;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
