package Data;

import Components.Messages.JOP;
import Debug.Components.Jack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {

	// implementando singleton
	// protecao EXTREMA com multiplas instancias
	// coisa lindaaaa
	private static ConnectionDB instance;

	public static synchronized ConnectionDB getInstance() {
		if (instance == null) {
			instance = new ConnectionDB();
		}
		return instance;
	}

	private ConnectionDB() {}

	private static Connection connection;
	private static Statement statement;

	protected static void init() {
		try {
			ConnectionDB.getInstance();

			// java data base connection
			// tipo de banco
			// server
			// base de dados
			String server = "jdbc:mysql://localhost:3306/bdjackcadastra";
			// configuracoes de login
			String user = "root";
			String senha = "";
			// driver utilizado
			// String driver = "com.mysql.jdbc.Driver";
			connection = DriverManager.getConnection(server, user, senha);
			statement = connection.createStatement();
		} catch (SQLException e) {
			Jack.writeLog(500, "MySql connection failed");
			JOP.showError("Falha na comunicação com o servidor");
			System.exit(500);
		}
	}

	protected Connection getConenction() throws SQLException {
		return ConnectionDB.connection;
	}

	protected Statement getStatement() throws SQLException {
		return ConnectionDB.statement;
	}
}
