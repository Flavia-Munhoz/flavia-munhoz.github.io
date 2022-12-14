package com.api.diversas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.api.diversas.model.SugestaoModel;
import com.api.diversas.repository.SugestaoRepository;

@Controller
@RequestMapping("/sistema/sugestao")
public class SugestaoController {

	@Autowired
	private SugestaoRepository sugestaoRepository;

	@RequestMapping(value = { "/novo" }, method = RequestMethod.GET)
	public ModelAndView formulario() {
		ModelAndView modelAndView = new ModelAndView();
		SugestaoModel conta = new SugestaoModel();
		modelAndView.setViewName("faq.html");
		modelAndView.addObject("registroAtualSugestao", conta);
		return modelAndView;
	}

	@RequestMapping(value = { "/salvar" }, method = RequestMethod.POST)
	public ModelAndView salvarSugestao(SugestaoModel conta) {
		ModelAndView modelAndView = new ModelAndView();

		try {
			sugestaoRepository.save(conta);
			modelAndView.setViewName("index.html");
		} catch (Exception ex) {
			modelAndView.setViewName("");
		}
		return modelAndView;

	}

}
