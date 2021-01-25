package br.com.zup.casadocodigo.autores;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.validation.EmailDuplicado;

public class AutorDTO {

	@NotBlank(message = "{campo.nome.autor}")
    private String nome;
    @Email(message = "{campo.email.autor}")
    @NotBlank(message = "{campo.email.autor}")
    @EmailDuplicado
    private String email;
    @NotBlank(message = "{campo.descricao.autor}") @Size(max = 400, message = "{campo.descmax.autor}")
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
