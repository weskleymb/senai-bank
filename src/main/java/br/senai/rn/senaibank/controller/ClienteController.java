package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.model.Sexo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController extends GenericController<Cliente> {

    private List<Sexo> sexos = Arrays.asList(Sexo.MASCULINO, Sexo.FEMININO);

    @Override
    public String form(Model model) {
        model.addAttribute("sexos", sexos);
        return super.form(model);
    }

    @Override
    public String edit(Long id, Model model) {
        model.addAttribute("sexos", sexos);
        return super.edit(id, model);
    }

}
