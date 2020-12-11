package Components.Calendar;

public class DataChoose {

	private static DataChoose instance;

	public static synchronized DataChoose getInstance(String[] values, boolean admin) throws Exception {
		if (instance == null) {
			instance = new DataChoose();
		}
		return instance;
  }
	public static synchronized DataChoose getInstance() throws Exception {
		return instance;
  }

	private DataChoose() {}

	private static Calendar calendar = new Calendar();

	public static void openCalendar() {
		calendar.setVisible(true);
	}

	public static void closeCalendar() {
		calendar.setVisible(false);
	}
	public static boolean isOpen() {
		return calendar.isVisible();
	}
}
