package br.senai.rn.senaibank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordGenarator {

    public static void main(String... args) {
        System.out.println("Senha(12345): " + new BCryptPasswordEncoder().encode("12345"));
        System.out.println("Senha(54321): " + new BCryptPasswordEncoder().encode("54321"));
    }

}
