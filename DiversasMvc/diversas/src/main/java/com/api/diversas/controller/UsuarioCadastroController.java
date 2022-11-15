package com.api.diversas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.api.diversas.model.UsuarioModel;
import com.api.diversas.repository.UsuarioRepository;

@RestController
@RequestMapping("/sistema/conta")
public class UsuarioCadastroController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = { "/novo" }, method = RequestMethod.GET)
	public ModelAndView formulario() {
		ModelAndView modelAndView = new ModelAndView();
		UsuarioModel conta = new UsuarioModel();
		modelAndView.setViewName("cadastrar.html");
		modelAndView.addObject("registroAtual", conta);
		return modelAndView;
	}

	@RequestMapping(value = { "/salvar" }, method = RequestMethod.POST)
	public ModelAndView salvarCadastro(UsuarioModel conta) {
		ModelAndView modelAndView = new ModelAndView();

		try {

			usuarioRepository.save(conta);
		} catch (Exception ex) {
			System.out.print("Erro");
			modelAndView.setViewName("login.html");
		}
		return modelAndView;

	}

	@RequestMapping(value = { "/excluir/{id}" }, method = RequestMethod.GET)
	public ModelAndView excluirCadastro(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		UsuarioModel conta = usuarioRepository.findById(id).get();
		usuarioRepository.delete(conta);
		modelAndView.setViewName("");
		modelAndView.addObject("", conta);
		return modelAndView;
	}

	@RequestMapping(value = { "/editar/{id}" }, method = RequestMethod.GET)
	public ModelAndView alterarCadastro(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		UsuarioModel conta = usuarioRepository.findById(id).get();
		modelAndView.setViewName("");
		modelAndView.addObject("", conta);
		return modelAndView;

	}

	/*
	 * @RequestMapping(value = {"/","lista"}, method = RequestMethod.GET) public
	 * ModelAndView listagem() { List<UsuarioModel> listaContas=
	 * (List<UsuarioModel>)usuarioRepository.findAll(); ModelAndView modelAndView =
	 * new ModelAndView(); modelAndView.setViewName("index.html");
	 * modelAndView.addObject("registroAtual", listaContas); return modelAndView; }
	 */

}
