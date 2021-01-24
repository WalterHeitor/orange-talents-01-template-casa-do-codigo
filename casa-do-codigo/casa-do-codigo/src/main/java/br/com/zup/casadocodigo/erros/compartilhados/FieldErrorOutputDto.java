package br.com.zup.casadocodigo.erros.compartilhados;

public class FieldErrorOutputDto {
    private String field;
    private String menssage;


    public FieldErrorOutputDto(String field, String menssage) {
        this.field = field;
        this.menssage = menssage;
    }

    public String getField() {
        return field;
    }

    public String getMenssage() {
        return menssage;
    }
}
