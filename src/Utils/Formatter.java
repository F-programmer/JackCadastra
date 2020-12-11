package Utils;

public class Formatter {
	public static String formatDate(String olDate) {
		String[] values = olDate.split("/");
		return values[2] + "-" + values[1] + "-" + values[0];
	}
}
