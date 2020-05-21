package br.senai.rn.senaibank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final String HOME_URL = "/";
    private final String LOGIN_URL = "/entrar";
    private final String LOGOUT_URL = "/sair";

    @GetMapping(value = HOME_URL)
    public String index() {
        return "public/index";
    }

    @GetMapping(value = LOGIN_URL)
    public String login() {
        return "public/login";
    }

    @GetMapping(value = LOGOUT_URL)
    public String logout() {
        return redirect(LOGIN_URL);
    }

    private String redirect(String url) {
        return "redirect:" + url;
    }

}
