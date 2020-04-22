package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/clientes")
    @ResponseBody
    public String buscaTodos() {
        return service.buscaTodos().toString();
    }

}
