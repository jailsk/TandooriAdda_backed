package com.resturant.tandoori_adda;

import org.springframework.boot.SpringApplication;
import com.resturant.tandoori_adda.config.FirebaseConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FirebaseConfig.class)
public class TandooriAddaApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(TandooriAddaApplication.class, args);
	}

}
