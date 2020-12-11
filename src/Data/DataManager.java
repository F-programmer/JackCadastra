package Data;

import Components.Messages.JOP;
import Debug.Components.Jack;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

	protected static int Post(String query) throws SQLException {
		try {
			ConnectionDB.getInstance();
			ConnectionDB.init();

			if (query.equals("")) {
				kill();
				return 0;
			}

			int state = ConnectionDB
				.getInstance()
				.getStatement()
				.executeUpdate(query);

			Jack.writeLog(200, "post request successfull");

			return state;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			kill();
			Jack.writeError(500, "MySql post request", e.getMessage());
			JOP.showError("Houve um problema\nO sistema precisa ser reiniciado");
			System.exit(500);
			throw new RuntimeException(e);
		}
	}

	protected static ArrayList<String[]> Get(String query, int[] indexes)
		throws SQLException {
		try {
			if (query.equals("")) return new ArrayList<String[]>();
			if (indexes.length == 0) return new ArrayList<String[]>();
			ConnectionDB.getInstance();
			ConnectionDB.init();
			ResultSet resultset = ConnectionDB
				.getInstance()
				.getStatement()
				.executeQuery(query);
			ArrayList<String[]> values = new ArrayList<String[]>();

			while (resultset.next()) {
				// resultset begin on index 1
				List<String> line = new ArrayList<String>();
				// o valor que comeca = index[0], quantos avanca = index[1]
				for (int i = indexes[0]; i < indexes[1]; i++) {
					line.add(resultset.getString(i + 1));
				}

				String[] consultLine = new String[line.size()];

				for (int i = 0; i < consultLine.length; i++) {
					consultLine[i] = line.get(i);
				}

				values.add(consultLine);
			}

			Jack.writeLog(200, "get request successfull");

			return values;
		} catch (SQLException e) {
			Jack.writeError(500, "MySql get request", e.getMessage());
			e.printStackTrace();
			kill();
			JOP.showError("Houve um problema\nO sistema precisa ser reiniciado");
			throw new RuntimeException(e);
		}
	}

	protected static int Delete(String query) throws SQLException {
		try {
			ConnectionDB.getInstance();
			ConnectionDB.init();

			if (query.equals("")) {
				kill();
				return 0;
			}

			int state = ConnectionDB
				.getInstance()
				.getStatement()
				.executeUpdate(query);

			Jack.writeLog(200, "delete request successfull");

			return state;
		} catch (SQLException e) {
			kill();
			Jack.writeError(500, "MySql delete request", e.getMessage());
			JOP.showError("Houve um problema\nO sistema precisa ser reiniciado");
			System.exit(500);
			throw new RuntimeException(e);
		}
	}

	public static void kill() throws SQLException {
		if (ConnectionDB.getInstance().getConenction() != null) ConnectionDB
			.getInstance()
			.getConenction()
			.close();
		if (ConnectionDB.getInstance().getStatement() != null) ConnectionDB
			.getInstance()
			.getStatement()
			.close();
	}
}
