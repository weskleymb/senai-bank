package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.model.Sexo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //    @GetMapping(value = "/{id}/editar")
//    public String editar(@PathVariable(value = "id") Long id, Model model) {
//        Cliente cliente = service.buscaPorId(id);
//        if (cliente == null) {
//            return "clientes/list";
//        }
//        model.addAttribute("cliente", cliente);
//        List<Sexo> sexos = new ArrayList<>();
//        sexos.add(Sexo.MASCULINO);
//        sexos.add(Sexo.FEMININO);
//        model.addAttribute("sexos", sexos);
//        return "clientes/form";
//    }
//


}
