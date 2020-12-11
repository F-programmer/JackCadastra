package Utils;

import java.util.HashMap;

public class PropsFormatter {
  private static int letterHeight = 20;
  private static int formVSpacing = 35;
  private static int formPaddingLetter = 10;

  public static int getLetterHeight() {
		return letterHeight;
	}

  public static int getFormVSpacing() {
		return formVSpacing;
	}
  
  public static int getFormPaddingLetter() {
		return formPaddingLetter;
	}

  public static HashMap position(int x, int y, int width, int height) {
    HashMap props = new HashMap();
    props.put("x", x);
    props.put("y", y);
    props.put("width", width);
    props.put("height", height);
    return props;
  }
}
