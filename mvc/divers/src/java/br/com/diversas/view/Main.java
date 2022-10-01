/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.diversas.view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.diversas.controller.CadastroDAO;
import br.com.diversas.model.Cadastro;

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
			}
		}
	}
}
