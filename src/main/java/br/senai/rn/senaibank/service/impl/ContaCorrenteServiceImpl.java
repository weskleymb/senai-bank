package br.senai.rn.senaibank.service.impl;

import br.senai.rn.senaibank.model.ContaCorrente;
import br.senai.rn.senaibank.service.ContaCorrenteService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ContaCorrenteServiceImpl
        extends GenericServiceImpl<ContaCorrente>
        implements ContaCorrenteService {
}
