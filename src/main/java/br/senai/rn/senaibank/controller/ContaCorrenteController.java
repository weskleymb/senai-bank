package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.model.ContaCorrente;
import br.senai.rn.senaibank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/contasCorrentes")
public class ContaCorrenteController extends GenericController<ContaCorrente> {

    @Autowired
    private ClienteService clienteService;

    @Override
    public String salva(ContaCorrente contaCorrente, RedirectAttributes atributos) {
        Cliente titular = clienteService.findByCpf(contaCorrente.getTitular().getCpf());
        if (titular == null) {
            atributos.addFlashAttribute("error", "Cliente não localizado");
            return redireciona(LISTA);
        }
        contaCorrente.setTitular(titular);
        return super.salva(contaCorrente, atributos);
    }

}
