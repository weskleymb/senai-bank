package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.model.Sexo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController extends GenericController<Cliente> {

    @Override
    public String formulario(Model modelo) {
        List<Sexo> sexos = Arrays.asList(Sexo.values());
        modelo.addAttribute("sexos", sexos);
        return super.formulario(modelo);
    }

    @Override
    @GetMapping(value = EDITAR)
    public String editar(@PathVariable(value = "id") Long id, Model modelo) {
        List<Sexo> sexos = Arrays.asList(Sexo.values());
        modelo.addAttribute("sexos", sexos);
        return super.editar(id, modelo);
    }

}
