package fabrica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexaoJDBC {
	
	public static Connection criarConexao() throws IOException, SQLException {
		InputStream is = FabricaConexaoJDBC.class.getClassLoader().getResourceAsStream("application.properties");
		if (is == null) {
			throw new FileNotFoundException("O arquivo de configura??o do banco de dados n?o foi encontrado");
		}
		Properties props = new Properties();
		props.load(is);
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(props.getProperty("urlConnection"),
				props.getProperty("userConnection"), props.getProperty("passwordConnection"));
		return conexao;
	}
}

