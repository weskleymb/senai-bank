package br.senai.rn.senaibank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    private static final String PASSWORD = "54321";

    public static void main(String[] args) {
        String password = "Senha(" + PASSWORD + "): " + new BCryptPasswordEncoder().encode(PASSWORD);
        System.out.println(password);
    }

}
