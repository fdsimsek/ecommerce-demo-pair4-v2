package com.etiya.ecommercedemopair4;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceDemoPair4Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoPair4Application.class, args);
	}

}
// Unit Test => Mock, Business Kodlar

// Kodu kodla test etmek

// Sana hali hazırda bir kategori verdiğimde bana "bu kategori zaten mevcut" exceptionı fırlat
// Mocklama