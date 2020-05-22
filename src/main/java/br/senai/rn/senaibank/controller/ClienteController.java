package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController extends GenericController<Cliente> {

//    @PostMapping(value = "/novo")
//    public String salvaCliente(Cliente cliente) {
//        System.out.println("VER AQUI");
//        service.salva(cliente);
//        return "redirect:/clientes/lista";
//    }
//
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
//    @GetMapping(value = "/{id}/remover")
//    public String remover(@PathVariable(value = "id") Long id) {
//        Cliente cliente = service.buscaPorId(id);
//        if (cliente != null) {
//            service.remover(cliente);
//        }
//        return "redirect:/clientes/lista";
//    }

}
