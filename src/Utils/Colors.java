package Utils;

import java.awt.*;
import java.util.HashMap;

public class Colors {

	private static HashMap<String, Color> colors = new HashMap();

	public static void init() {
		colors.put("primary", Color.decode("#bd3d6d"));
		colors.put("secondary", Color.decode("#8313CF"));
		colors.put("terciary", Color.decode("#777777"));
		colors.put("text", Color.decode("#ffffff"));
		colors.put("textDark", Color.decode("#565656"));
		colors.put("auxiliar", Color.decode("#13265b"));
		colors.put("modal", Color.decode("#333333"));
		colors.put("cancel", Color.decode("#fc2032"));
		colors.put("light", Color.decode("#cccccc"));
	}

	public static Color get(String color) {
		return (Color) colors.get(color);
	}
}
