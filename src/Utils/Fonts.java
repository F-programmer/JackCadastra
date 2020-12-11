package Utils;

import java.awt.*;
import java.util.HashMap;

public class Fonts {
  private static HashMap fonts = new HashMap();

  public static void init() {
    fonts.put("Verdana", "Verdana");
    fonts.put("Comic Sans MS", "Comic Sans MS");
    fonts.put("Monospaced", "Monospaced");
    fonts.put("Calibri", "Calibri");
    fonts.put("primary", "Verdana");
  }

  public static Font get(String font, int size) {
    return new Font((String) fonts.get(font), Font.PLAIN, size);
  }
}
