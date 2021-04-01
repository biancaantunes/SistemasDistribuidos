

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroDB {

	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;

	public CadastroDB() {
		connection = Conexao.getConnection();
	}

	public boolean inserir(Message message) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("INSERT INTO CHAT (usuario, mensagem) values (?, ?)");

			stmt.setString(1, message.getUsuario());
			stmt.setString(2, message.getMensagem());

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}

	/*public boolean alterar(Message message) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("UPDATE AGENDA SET nome = ?, telefone = ? WHERE codigo = ?");

			stmt.setString(1, message.getNome());
			stmt.setString(2, message.getTelefone());
			stmt.setInt(3, message.getCodigo());

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}

	public List<Message> getAll() {

		List<Message> lstCadastro = new ArrayList<>();
		try {
			ps = this.connection.prepareStatement("SELECT codigo, nome, telefone FROM AGENDA");
			rs = ps.executeQuery();

			while (rs.next()) {
				lstCadastro.add(new Message(rs.getInt("codigo"), rs.getString("nome"), rs.getString("telefone")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstCadastro;
	}

	public boolean excluir(int codigo) throws SQLException {

		try {

			PreparedStatement stmt = this.connection.prepareStatement("DELETE FROM AGENDA WHERE CODIGO =?");

			stmt.setInt(1, codigo);

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}*/
}