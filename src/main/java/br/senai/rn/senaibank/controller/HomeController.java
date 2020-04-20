package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.model.Conta;
import br.senai.rn.senaibank.model.Sexo;
import br.senai.rn.senaibank.repositoy.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        Cliente jadson = new Cliente("Jadson", "111222", Sexo.MASCULINO);
        Conta contaJadson = new Conta(jadson, "1234-5", 500.0);

        clienteRepository.save(jadson);

        return contaJadson.getTitular().getNome();
    }

}
