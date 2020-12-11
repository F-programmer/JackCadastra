import javax.swing.JFrame;

import Utils.Screens;
import Utils.InitiApplication;

public class Application {
  public static void main(String[] args) throws Exception{
		InitiApplication.init();
    try {
			((JFrame) Screens.get("screenLogin")).setVisible(true);
    } catch (Exception e) {
      System.out.println(e.getMessage());
		}
	}
}
