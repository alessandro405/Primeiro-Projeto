package interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
	
	public interface AgendaRepositorio<T> {

		List <T> selecionar() throws SQLException, IOException;
		void inserir(T entidades) throws SQLException, IOException;
		void editar(T entidades) throws SQLException, IOException;
		void excluir(T entidades) throws SQLException, IOException;

	}
