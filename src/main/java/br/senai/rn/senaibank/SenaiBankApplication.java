package br.senai.rn.senaibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SenaiBankApplication {

    public static void main(String... args) {
        SpringApplication.run(SenaiBankApplication.class, args);
        run();
    }

    private static void run() {
        System.out.println("Senha(12345): " + new BCryptPasswordEncoder().encode("12345"));
        System.out.println("Senha(54321): " + new BCryptPasswordEncoder().encode("54321"));
    }

}
