package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.model.Sexo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController extends GenericController<Cliente> {

    @Override
    public String form(Model model) {
        model.addAttribute("sexos", Arrays.asList(Sexo.values()));
        return super.form(model);
    }

    @Override
    @GetMapping(value = EDIT)
    public String edit(@PathVariable(value = "id") Long id, Model model, RedirectAttributes attributes) {
        model.addAttribute("sexos", Arrays.asList(Sexo.values()));
        return super.edit(id, model, attributes);
    }

}
