package br.com.zup.casadocodigo.autores;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTO {

	@NotBlank
    private String nome;
    @Email
    @NotBlank
    //@Unique
    private String email;
    @NotBlank @Size(max = 400)
    private String descricao;



    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor transformaParaObjeto(){
        return new Autor(this.nome, this.email, this.descricao);}
}
