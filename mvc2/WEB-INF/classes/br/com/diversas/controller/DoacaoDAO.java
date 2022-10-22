
package br.com.diversas.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.diversas.model.Doacao;
import br.com.diversasFactory.ConnectionFactory;

public class DoacaoDAO {

	// Aqui é onde funciona o INSERT ficara como SAVE para fazer registros
	public void save(Doacao doacao) throws SQLException {
		String sql = "INSERT INTO doacao (tipo_doacao, nome, email, mensagem)VALUES(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Criar uma conexao com o Bd
			conn = ConnectionFactory.createConnectionToMySQl();
			// Criamos um prepareStatement para criar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, doacao.getTipo_doacao());
			pstm.setString(2, doacao.getNome());
			pstm.setString(3, doacao.getEmail());
			pstm.setString(4, doacao.getMensagem());

			// Executar a query
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

	// Aqui é onde funciona o SELECT ficara como getDoacao para fazer consulta de
	// dados
	public List<Doacao> getDoacao() throws SQLException {

		String sql = "SELECT * FROM doacao";

		List<Doacao> doacao = new ArrayList<Doacao>();

		Connection conn = null;

		PreparedStatement pstm = null;

		ResultSet rset = null;
		String string = "";

		try {
			conn = ConnectionFactory.createConnectionToMySQl();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Doacao doacaoslct = new Doacao();

				// Recuperar tipo_doacao
				doacaoslct.setTipo_doacao(rset.getString("tipo_doacao"));
				// Recuperar nome
				doacaoslct.setNome(rset.getString("nome"));
				// Recuperar email
				doacaoslct.setEmail(rset.getString("email"));
				// Recuperar mensagem
				doacaoslct.setMensagem(rset.getString("mensagem"));
				string = string + "Tipo_doacao: " + rset.getString("tipo_doacao") + " - Nome: " + rset.getString("nome") + " - Email: "
						+ rset.getString("email") +  "Mensagem:   " + rset.getString("mensagem")+ "\n";
				doacao.add(doacaoslct);
				
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
		}
		return doacao;
		
	}

	// Aqui é onde funciona o UPDATE para atualizar os dados
	public void updateS(int id,  Doacao doacao) throws SQLException {
		String sql = "UPDATE doacao SET    tipo_doacao= ?,  nome= ?,  email= ?,  mensagem= ?" + "WHERE id_doacao= ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQl();

			pstm = (PreparedStatement)

			conn.prepareStatement(sql);

			// Adiacionar os valores para atualizar
			pstm.setString(1, doacao.getTipo_doacao());
			pstm.setString(2, doacao.getNome());
			pstm.setString(3, doacao.getEmail());
			pstm.setString(4, doacao.getMensagem());
			pstm.setInt(5, id);

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
	public void deleteByID(int id_doacao) {
		String sql = "DELETE FROM doacao WHERE id_doacao = ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQl();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setInt(1, id_doacao);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();

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
