package Data;

import Debug.Components.Jack;
import Personas.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {

	public static boolean login(String email, String senha) throws Exception {
		try {
			String query = "SELECT * FROM tbCLiente ";
			query += "WHERE tbCliente.emailCliente = '" + email + "' ";
			query += "AND ";
			query += "tbCliente.senhaCliente = '" + senha + "' ";

			int[] indexes = { 0, 12 };

			List<String[]> values = DataManager.Get(query, indexes);
			if (!haveNull(values) && values.size() == 1) {
				query = "";
				query += "SELECT * FROM tbAdmin ";
				query += "INNER JOIN tbCliente ";
				query += "ON tbAdmin.idCliente = tbCliente.idCliente ";
				query += "WHERE tbAdmin.idCliente = " + values.get(0)[0] + " ";

				indexes[0] = 0;
				indexes[1] = 2;

				List<String[]> isAdmin = DataManager.Get(query, indexes);

				DataManager.kill();

				boolean admin = false;
				if (!haveNull(isAdmin) && isAdmin.size() == 1) admin = true;

				String[] userInfos = listToArray(values, 0);
				User.getInstance(splitArray(userInfos, 1), admin);
				User.getInstance().setId(values.get(0)[0]);

				return true;
			} else {
				DataManager.kill();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			DataManager.kill();
			return false;
		}
	}

	public static int getCountUsers() throws Exception {
		String query = "SELECT COUNT(tbCliente.idCliente) FROM tbCliente";
		int[] indexes = { 0, 1 };
		List<String[]> values = DataManager.Get(query, indexes);
		DataManager.kill();
		if (!haveNull(values) && values.size() == 1) {
			String[] results = listToArray(values, 0);
			return Integer.parseInt(results[0]);
		}
		return 0;
	}

	public static int getCountAdmins() throws Exception {
		String query = "SELECT COUNT(tbAdmin.idAdmin) FROM tbAdmin";
		int[] indexes = { 0, 1 };
		List<String[]> values = DataManager.Get(query, indexes);
		DataManager.kill();
		if (!haveNull(values) && values.size() == 1) {
			String[] results = listToArray(values, 0);
			return Integer.parseInt(results[0]);
		}
		return 0;
	}

	public static boolean userRegistrer(String[] values) {
		String query =
			"INSERT INTO tbCliente (nomeCliente, cpfCliente, rgCliente, dtNasCliente, sexoCliente, endCliente, bairroCliente, municipioCliente, ufCliente, emailCliente, senhaCliente)";
		query += "VALUES (";

		query += "'" + values[0] + "', ";
		query += "'" + values[1] + "', ";
		query += "'" + values[2] + "', ";
		query += "'" + values[3] + "', ";
		query += "'" + values[4] + "', ";
		query += "'" + values[5] + "', ";
		query += "'" + values[6] + "', ";
		query += "'" + values[7] + "', ";
		query += "'" + values[8] + "', ";
		query += "'" + values[9] + "', ";
		query += "'" + values[10] + "'";

		query += ")";

		try {
			int state = DataManager.Post(query);

			if (state > 0) {
				query = "";
				query +=
					"INSERT INTO tbTelefoneCliente (idCliente, numTelefoneCliente)";
				query += "VALUES (";

				query += "'" + state + "', ";
				query += "'" + values[11] + "'";

				query += ")";

				state = DataManager.Post(query);
				return state == 0 ? false : true;
			}
		} catch (SQLException e) {
			Jack.writeError(417, "user register", e.getMessage());
		}
		// ja aplica a tudo
		return false;
	}

	public static List<List<String>> getAllUsersNotAdmin() {
		try {
			String query = "SELECT * FROM tbCliente ";
			int[] indexes = { 0, 11 };
			List<String[]> values;
			values = DataManager.Get(query, indexes);
			query = "SELECT * FROM tbAdmin";
			indexes[1] = 2;
			List<String[]> admins;
			admins = DataManager.Get(query, indexes);
			DataManager.kill();
			if (!haveNull(values) && values.size() >= 1) {
				List<List<String>> results = new ArrayList<List<String>>();
				for (int i = 0; i < values.size(); i++) {
					List<String> line = new ArrayList<String>();

					line.add(values.get(i)[0]);
					line.add(values.get(i)[1]);
					line.add(values.get(i)[2]);

					boolean isAdmin = false;
					for (int j = 0; j < admins.size(); j++) {
						if (admins.get(j)[1].equals(values.get(i)[0])) {
							isAdmin = true;
							break;
						}
					}

					line.add(isAdmin ? "true" : "false");

					results.add(line);
				}

				return results;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean promoveAdmin(int idCliente) {
		//eh aqui que tu lanca o update : )
		// boa sorte amigo

		String query = "INSERT INTO tbAdmin (idCliente) ";
		query += "VALUES (" + idCliente + ") ";

		try {
			int status = DataManager.Post(query);
			return status == 1 ? true : false;
		} catch (SQLException e) {
			Jack.writeError(500, "promoving admin", e.getMessage());
		}

		return false;
	}

	public static boolean despromoveAdmin(int idCliente) {
		//eh aqui que tu lanca o update : )
		// boa sorte amigo

		String script = "DELETE from tbAdmin ";
		script += "WHERE idCliente = " + idCliente + ";";

		try {
			int status = DataManager.Delete(script);
			return status >= 1 ? true : false;
		} catch (SQLException e) {
			Jack.writeError(500, "despromoving admin", e.getMessage());
		}

		return false;
	}

	public static boolean deleteUser(int idCliente) {
		try {
			String script = "DELETE from tbAdmin ";
			script += "WHERE idCliente = " + idCliente + ";";
			DataManager.Delete(script);

			script = "";
			script = "DELETE from tbCliente ";
			script += "WHERE idCliente = " + idCliente + ";";

			int status = DataManager.Delete(script);

			Jack.writeLog(200, "user deleting completed");

			return status >= 1 ? true : false;
		} catch (SQLException e) {
			Jack.writeError(500, "deleting user", e.getMessage());
		}

		return false;
	}

	private static boolean haveNull(List<String[]> values) {
		boolean isNull = false;

		for (int i = 0; i < values.size(); i++) {
			String[] item = values.get(i);
			boolean lineNull = false;
			for (int j = 0; j < item.length; j++) {
				if (item[i].equals("")) {
					lineNull = true;
					break;
				}
			}
			if (lineNull) {
				isNull = true;
				break;
			}
		}

		return isNull;
	}

	private static String[] listToArray(List<String[]> list, int index) {
		String[] array = new String[list.get(index).length];

		String[] line = list.get(index);
		for (int i = 0; i < line.length; i++) {
			array[i] = line[i];
		}

		return array;
	}

	public static String[] splitArray(String[] array, int beginIndex) {
		String[] returnsArray = new String[array.length - beginIndex];

		for (int i = beginIndex; i < array.length; i++) {
			returnsArray[i - beginIndex] = array[i];
		}

		return returnsArray;
	}
}
