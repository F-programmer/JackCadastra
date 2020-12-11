package Utils;

import Generic.Login;
import Journeys.Admin.Interfaces.Cadastro.CadAdmins;
import Journeys.Admin.Interfaces.Cadastro.CadUsers;
import Journeys.Admin.Interfaces.Delete.DeleteUsers;
import Journeys.Admin.Interfaces.Home;
import java.util.HashMap;

public class Screens {

	private static HashMap<Object, Object> screens = new HashMap<Object, Object>();

	public static void init() throws Exception {
		screens.put("screenLogin", new Login(600, 600));
		screens.put("screenAdminHome", new Home());
		screens.put("screenAdminCadUser", new CadUsers());
		screens.put("screenAdminPromoveUser", new CadAdmins());
		screens.put("screenDeleteUser", new DeleteUsers());
	}

	public static Object get(String params) {
		return Screens.screens.get(params);
	}
}
