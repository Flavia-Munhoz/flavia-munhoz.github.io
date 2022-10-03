/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.diversas.view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.diversas.controller.CadastroDAO;
import br.com.diversas.controller.DoacaoDAO;
import br.com.diversas.controller.SugestaoDAO;
import br.com.diversas.model.Cadastro;
import br.com.diversas.model.Doacao;
import br.com.diversas.model.Sugestao;

public class Main {

	public static void main(String[] args) throws SQLException {

		String opcao = "";
		String escolha = "";

		while (!opcao.equalsIgnoreCase("0")) {
			String texto = "Diversas  \n" + "Seja Bem Vindo\n" + "Digite sua opcão: \n" + "1 -  Usuario\n"
					+ "2 - Doação  \n" + "3 - Sugestão\n" + "0 - Sair";
			opcao = JOptionPane.showInputDialog(texto);

			switch (opcao) {
			case "1":
				String opcao1 = "Diversas \n" + "Menu Usuário\n" + "Digite sua opção: \n" + "1 - Adicionar\n"
						+ "2- Consultar\n" + "3 - Atualizar\n" + "4 - Excluir\n" + "0 - Voltar\n";

				escolha = JOptionPane.showInputDialog(opcao1);
				switch (escolha) {
				case "1":
					CadastroDAO cadastroDAO = new CadastroDAO();
					Cadastro cadastro = new Cadastro();
					cadastro.setNome(JOptionPane.showInputDialog("Nome completo: "));
					cadastro.setEmail(JOptionPane.showInputDialog("Email: "));
					cadastro.setCpf(JOptionPane.showInputDialog("CPF: "));
					cadastro.setSenha(JOptionPane.showInputDialog("Senha: "));
					cadastroDAO.save(cadastro);
					JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
					break;

				case "2":
					CadastroDAO cadastroDAO2 = new CadastroDAO();
					JOptionPane.showMessageDialog(null, cadastroDAO2.getCadastro());
					break;

				case "3":
					CadastroDAO cadastroDAO3 = new CadastroDAO();
					int id_cadastro = Integer.valueOf(JOptionPane.showInputDialog("ID Cadastro: "));
					Cadastro cadastro2 = new Cadastro();
					cadastro2.setNome(JOptionPane.showInputDialog("Nome completo: "));
					cadastro2.setEmail(JOptionPane.showInputDialog("Email: "));
					cadastro2.setCpf(JOptionPane.showInputDialog("CPF: "));
					cadastro2.setSenha(JOptionPane.showInputDialog("Senha: "));
					cadastroDAO3.update(id_cadastro, cadastro2);
					JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso!");
					break;
				case "4":
					CadastroDAO cadastroDAO4 = new CadastroDAO();
					int id_cadastro2 = Integer.valueOf(JOptionPane.showInputDialog("ID Cadastro: "));
					cadastroDAO4.deleteByID(id_cadastro2);
					break;
				case "0":
					break;
				default:
					break;
				}
				break;

			case "2":
				String opcao2 = "Diversas \n" + "Menu Doacao\n" + "Digite sua opção: \n" + "1 - Adicionar\n"
						+ "2- Consultar\n" + "3 - Atualizar\n" + "4 - Excluir\n" + "0 - Voltar\n";

				escolha = JOptionPane.showInputDialog(opcao2);
				switch (escolha) {
				case "1":
					DoacaoDAO doacaoDAO = new DoacaoDAO();
					Doacao doacao = new Doacao();
					doacao.setNome(JOptionPane.showInputDialog("Nome completo: "));
					doacao.setEmail(JOptionPane.showInputDialog("Email: "));
					doacao.setTipo_doacao(JOptionPane.showInputDialog("Informe o tipo de doação: "));
					doacao.setMensagem(JOptionPane.showInputDialog("Mensagem Doação: "));
					doacaoDAO.save(doacao);
					JOptionPane.showMessageDialog(null, "Doação cadastrada com sucesso!");
					break;

				case "2":
					DoacaoDAO doacaoDAO2 = new DoacaoDAO();
					JOptionPane.showMessageDialog(null, doacaoDAO2.getDoacao());
					break;

				case "3":
					DoacaoDAO doacaoDAO3 = new DoacaoDAO();
					int id_doacao = Integer.valueOf(JOptionPane.showInputDialog("ID Cadastro: "));
					Doacao doacao3 = new Doacao();
					doacao3.setNome(JOptionPane.showInputDialog("Nome completo: "));
					doacao3.setEmail(JOptionPane.showInputDialog("Email: "));
					doacao3.setTipo_doacao(JOptionPane.showInputDialog("Tipo de doação: "));
					doacao3.setMensagem(JOptionPane.showInputDialog("Mensagem: "));
					doacaoDAO3.updateS(id_doacao, doacao3);
					JOptionPane.showMessageDialog(null, "Parametros de doação, atualizados com sucesso!");
					break;
				case "4":
					DoacaoDAO doacaoDAO4 = new DoacaoDAO();
					int id_doacao1 = Integer.valueOf(JOptionPane.showInputDialog("ID doaçao: "));
					doacaoDAO4.deleteByID(id_doacao1);
					break;
				case "0":
					break;
				default:
					break;
				}
				break;

			case "3":
				String opcao3 = "Diversas \n" + "Menu Sugestâo\n" + "Digite sua opção: \n" + "1 - Adicionar\n"
						+ "2- Consultar\n" + "3 - Atualizar\n" + "4 - Excluir\n" + "0 - Voltar\n";

				escolha = JOptionPane.showInputDialog(opcao3);
				switch (escolha) {
				case "1":
					SugestaoDAO sugestaoDAO = new SugestaoDAO();
					Sugestao sugestao = new Sugestao();
					sugestao.setNome(JOptionPane.showInputDialog("Nome completo: "));
					sugestao.setEmail(JOptionPane.showInputDialog("Email: "));
					sugestao.setSugestao(JOptionPane.showInputDialog("Sugestão: "));
					sugestaoDAO.save(sugestao);
					JOptionPane.showMessageDialog(null, "Sugestão cadastrada com sucesso!");
					break;

				case "2":
					SugestaoDAO sugestaoDAO2 = new SugestaoDAO();
					JOptionPane.showMessageDialog(null, sugestaoDAO2.getSugestao());
					break;

				case "3":
					SugestaoDAO sugestaoDAO3 = new SugestaoDAO();
					int id_sugestao = Integer.valueOf(JOptionPane.showInputDialog("ID sugestão: "));
					Sugestao sugestao3 = new Sugestao();
					sugestao3.setNome(JOptionPane.showInputDialog("Nome completo: "));
					sugestao3.setEmail(JOptionPane.showInputDialog("Email: "));
					sugestao3.setSugestao(JOptionPane.showInputDialog("Sugestao: "));
					sugestaoDAO3.updateS(id_sugestao, sugestao3);
					JOptionPane.showMessageDialog(null, "Parametros de Sugestão, atualizados com sucesso!");
					break;
				case "4":
					SugestaoDAO sugestaoDAO4 = new SugestaoDAO();
					int id_sugestao1 = Integer.valueOf(JOptionPane.showInputDialog("ID doaçao: "));
					sugestaoDAO4.deleteByID(id_sugestao1);
					break;
				case "0":
					break;
				default:
					break;
				}
				break;
			case "0":
				break;
			default:
				break;

			}
		}
	}
}
