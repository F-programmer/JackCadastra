package Utils;

public class ValidFields {
	public static boolean valid(String field) throws Exception {

		boolean valid = true;
		char[] forbiddens = { '(', ')', '{', '}', '#', '!', '$', '%', '_', '<', '>', ';', '?', '"', '\'', '\\',
				'|', '*', ':', ',', '+' };
		for (char letter : field.toCharArray()) {
			for (char character : forbiddens) {
				if (letter == character) {
					break;
				}
			}
		}

		return valid;
	}
}
