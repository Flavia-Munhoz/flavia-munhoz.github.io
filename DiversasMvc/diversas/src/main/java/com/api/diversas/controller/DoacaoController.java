package com.api.diversas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.api.diversas.model.DoacaoModel;
import com.api.diversas.repository.DoacaoRepository;

@Controller
@RequestMapping("/sistema/doacao")
public class DoacaoController {

	@Autowired
	private DoacaoRepository doacaoRepository;

	@RequestMapping(value = { "/novo" }, method = RequestMethod.GET)
	public ModelAndView formulario() {
		ModelAndView modelAndView = new ModelAndView();
		DoacaoModel doacao = new DoacaoModel();
		modelAndView.setViewName("doacao.html");
		modelAndView.addObject("registroAtualDoacao", doacao);
		return modelAndView;
	}

	@RequestMapping(value = { "/salvar" }, method = RequestMethod.POST)
	public ModelAndView salvarDoacao(DoacaoModel doacao) {
		ModelAndView modelAndView = new ModelAndView();

		try {
			doacaoRepository.save(doacao);
			modelAndView.setViewName("index.html");
		} catch (Exception ex) {
			modelAndView.setViewName("");
		}
		return modelAndView;

	}

}
