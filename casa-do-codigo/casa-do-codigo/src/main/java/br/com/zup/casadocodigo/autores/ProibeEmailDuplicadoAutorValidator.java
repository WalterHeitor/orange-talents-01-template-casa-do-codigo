package br.com.zup.casadocodigo.autores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRespostaDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        AutorRespostaDTO autorRespostaDTO = (AutorRespostaDTO) target;
        Optional<Autor> possivelAutor = autorRepository.findByEmail(autorRespostaDTO.getEmail());
        if (possivelAutor.isPresent()){
            errors.rejectValue("email",null,"Jรก existe um(a) outro(a) autor(a)" +
                    " com este mesmo email: "+ autorRespostaDTO.getEmail());
        }
    }
}
