package br.senai.rn.senaibank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordGenarator {

    private static final String senha = "senai";

    public static void main(String... args) {
        System.out.println("Senha("+senha+"): " + new BCryptPasswordEncoder().encode(senha));
    }

}
