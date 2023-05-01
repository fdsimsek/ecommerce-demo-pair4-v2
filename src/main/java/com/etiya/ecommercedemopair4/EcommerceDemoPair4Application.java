package com.etiya.ecommercedemopair4;

import com.etiya.ecommercedemopair4.core.exceptions.BusinessException;
import com.etiya.ecommercedemopair4.core.utilities.result.ErrorResult;
import com.etiya.ecommercedemopair4.core.utilities.result.Result;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@RestControllerAdvice
public class EcommerceDemoPair4Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoPair4Application.class, args);
	}

	@Bean
	public ResourceBundleMessageSource resourceBundleMessageSource() {
		// Veritabanı?
		// Dosya
		// API
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		//Clientdan seçili dili hangi yöntemle almalıyım
		AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();

		// Dil gönderilmemişse hangi dil baz alayım?
		acceptHeaderLocaleResolver.setDefaultLocale(new Locale("tr"));

		return acceptHeaderLocaleResolver;
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@ExceptionHandler({BusinessException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result handleBusinessException(BusinessException businessException) {
		return new ErrorResult(businessException.getMessage());
	}

	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Object handleValidationException(MethodArgumentNotValidException exception) {
		//gelen exceptiondaki validasyon hatalarını oku liste olarak kullanıcıya göster
		Map<String, String> errors = new HashMap<>();

		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return errors;
	}
}
// Unit Test => Mock, Business Kodlar

// Kodu kodla test etmek

// Sana hali hazırda bir kategori verdiğimde bana "bu kategori zaten mevcut" exceptionı fırlat
// Mocklama