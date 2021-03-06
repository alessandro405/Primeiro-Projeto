package impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Usuario;
import fabrica.FabricaConexaoJDBC;

public class UsuarioRepositorioJDBC {

	public Usuario autenticar(Usuario user) throws IOException, SQLException {
		Usuario usuario = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conexao = null;
		try {
			conexao = FabricaConexaoJDBC.criarConexao();

			String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
			ps = conexao.prepareStatement(sql);

			ps.setString(1, user.getEmail());
			ps.setString(2, user.getSenha());
			rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new Usuario(rs.getString(1), rs.getString(1));
			}

		} catch (Exception e) {
			System.out.println("Erro em obter usuario");
		}
		return usuario;
	}

	
	
	public Usuario criarUser(Usuario user) throws IOException, SQLException {
		Connection conexao = null;
		try {
			conexao = FabricaConexaoJDBC.criarConexao();
			PreparedStatement comando = conexao
					.prepareStatement("INSERT INTO usuarios (email, senha) " + " VALUES (?, ?)");
			comando.setString(1, user.getEmail());
			comando.setString(2, user.getSenha());
			comando.execute();
	
		} finally {
			if (conexao != null) {
				conexao.close();
			}
		}
		return user;

	}
}