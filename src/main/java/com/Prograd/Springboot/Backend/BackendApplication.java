package com.Prograd.Springboot.Backend;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.password.PasswordEncoder;


//public class BackendApplication implements CommandLineRunner {
@SpringBootApplication
public class BackendApplication {
	//@Autowired
	//private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(this.passwordEncoder.encode("nancyM"));
//	}
}
