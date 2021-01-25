package br.com.zup.casadocodigo.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class InternacionalizacaoConfig {

	/**
	 *  Este método externalizá as mensagens de erro,
	 *  no qual pode  criar um messages.properties para cada linguagem
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = 
				new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:messages");
		bundleMessageSource.setDefaultEncoding("ISO-8859-1");
		bundleMessageSource.setDefaultLocale(Locale.getDefault());
		return bundleMessageSource;	
	}
	/**
	 * Método responsável por alterar as mensagens de erro
	 *  da aplicação para o arquivo massage.properties.
	 * @return
	 */
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
		factoryBean.setValidationMessageSource(messageSource());
		return factoryBean;
	}
	
}
