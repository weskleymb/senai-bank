package br.senai.rn.senaibank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    protected static final String HOME = "/";
    protected static final String LOGIN = "/entrar";
    protected static final String LOGOUT = "/sair";
    protected static final String NOT_FOUND = "/page-not-found";

    @GetMapping(value = HOME)
    public String index() {
        return "public/index";
    }

    @GetMapping(value = LOGIN)
    public String login() {
        return "public/login";
    }

    @PostMapping(value = LOGOUT)
    public String logout() {
        return "redirect:" + LOGIN;
    }

    @GetMapping(value = NOT_FOUND)
    public String notFound() {
        return "public/not-found";
    }

}
