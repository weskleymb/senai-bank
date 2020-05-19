package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.model.Sexo;
import br.senai.rn.senaibank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/lista")
    public String buscaTodos(Model model) {
        List<Cliente> clientes = service.buscaTodos();
        model.addAttribute("clientes", clientes);
        return "clientes/list";
    }

    @GetMapping(value = "/novo")
    public String form(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        List<Sexo> sexos = new ArrayList<>();
        sexos.add(Sexo.MASCULINO);
        sexos.add(Sexo.FEMININO);
        model.addAttribute("sexos", sexos);
        return "clientes/form";
    }

    @PostMapping(value = "/novo")
    public String salvaCliente(Cliente cliente) {
        System.out.println("VER AQUI");
        service.salva(cliente);
        return "redirect:/clientes/lista";
    }

    @GetMapping(value = "/{id}/editar")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        Cliente cliente = service.buscaPorId(id);
        if (cliente == null) {
            return "clientes/list";
        }
        model.addAttribute("cliente", cliente);
        List<Sexo> sexos = new ArrayList<>();
        sexos.add(Sexo.MASCULINO);
        sexos.add(Sexo.FEMININO);
        model.addAttribute("sexos", sexos);
        return "clientes/form";
    }

    @GetMapping(value = "/{id}/remover")
    public String remover(@PathVariable(value = "id") Long id) {
        Cliente cliente = service.buscaPorId(id);
        if (cliente != null) {
            service.remover(cliente);
        }
        return "redirect:/clientes/lista";
    }

}
