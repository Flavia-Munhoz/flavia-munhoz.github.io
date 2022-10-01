
package br.com.diversas.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.diversas.model.Cadastro;
import br.com.diversasFactory.ConnectionFactory;

public class CadastroDAO {

	// Aqui é onde funciona o INSERT ficara como SAVE para fazer registros
	public void save(Cadastro cadastro) {
		String sql = "INSERT INTO cadastro (nome, email, senha, cpf)VALUES(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQl();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, cadastro.getNome());
			pstm.setString(2, cadastro.getEmail());
			pstm.setInt(3, cadastro.getSenha());
			pstm.setString(4, cadastro.getCpf());

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();

				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	// Aqui é onde funciona o SELECT ficara como getSugestao para fazer consulta de
	// dados
	public List<Cadastro> getCadastro() {

		String sql = "SELECT * FROM cadastro";

		List<Cadastro> cadastro = new ArrayList<Cadastro>();

		Connection conn = null;

		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQl();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Cadastro cadastroslct = new Cadastro();

				// Recuperar nome
				cadastroslct.setNome(rset.getString("nome"));
				// Recuperar email
				cadastroslct.setEmail(rset.getString("email"));
				// Recuperar senha
				cadastroslct.setSenha(rset.getInt("senha"));
				// Recuperar cpf
				cadastroslct.setCpf(rset.getString("cpf"));

				cadastro.add(cadastroslct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {

					rset.close();

				}
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return cadastro;

		}

	}

	// Aqui é onde funciona o UPDATE para atualizar os dados
	public void update(Cadastro cadastro) throws SQLException {
		String sql = "UPDATE cadastro SET  nome= ?,email= ?,senha= ?,cpf= ?" + "WHERE id_cadastro= ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQl();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, cadastro.getNome());
			pstm.setString(2, cadastro.getEmail());
			pstm.setInt(3, cadastro.getSenha());
			pstm.setString(4, cadastro.getCpf());
			pstm.setInt(5, cadastro.getId_cadastro());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Deletar dados da tabela
	public void deleteByID(int id_cadastro) throws SQLException {
		String sql = "DELETE FROM cadastro WHERE id_cadastro = ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQl();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setInt(1, id_cadastro);

			pstm.execute();

		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstm != null)
					pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}