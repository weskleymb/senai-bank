package br.senai.rn.senaibank.controller;

import br.senai.rn.senaibank.model.ContaCorrente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/contasCorrentes")
public class ContaCorrenteController extends GenericController<ContaCorrente> {
}
