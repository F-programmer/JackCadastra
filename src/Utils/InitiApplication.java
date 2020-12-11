package Utils;

import Debug.Components.Jack;

public class InitiApplication {

	public static void init() throws Exception {
		Jack.init();

		Colors.init();
		Fonts.init();
		Screens.init();
	}
}
