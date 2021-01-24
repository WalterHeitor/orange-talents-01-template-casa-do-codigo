package br.com.zup.casadocodigo.autores;

import org.springframework.util.Assert;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotBlank
	    @Column(nullable = false)
	    private String nome;
	    @NotBlank @Email
	    @Column(nullable = false, unique = true)
	    private String email;
	    @Column(nullable = false)
	    @NotBlank @Size(max = 400)
	    private String descricao;
	    @Column(nullable = false)
	    private LocalDateTime dataCriacao = LocalDateTime.now();

	    @Deprecated
	    public Autor() {
	    }

	    public Autor(@NotBlank String nome, @NotBlank @Email String email,
	                 @NotBlank @Size(max = 400) String descricao) {

	        Assert.hasLength(nome, "O nome é obrigatório.");
	        Assert.hasLength(email, "O email é obrigatório.");
	        Assert.hasLength(descricao, "A descrição é obrigatória.");



	        this.nome = nome;
	        this.email = email;
	        this.descricao = descricao;
	    }
	    

	    public Long getId() {
	        return id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getDescricao() {
	        return descricao;
	    }
	    public LocalDateTime getDataCriacao() {
			return dataCriacao;
		}

	    @Override
	    public String toString() {
	        return "Autor{" +
	                "id=" + id +
	                ", nome='" + nome + '\'' +
	                ", email='" + email + '\'' +
	                ", descricao='" + descricao + '\'' +
	                ", dataCriacao=" + dataCriacao +
	                '}';
	    }
}
