package Debug.Components;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import Utils.PathResolve;

public class Jack {
	public static void writeLog(int status, String message) {
		List<String> logMessage = new ArrayList<String>();

		logMessage.add("Jack log: on " + getTime());
		logMessage.add("Jack status: " + status);
		logMessage.add("Jack occurence: " + message);
		logMessage.add("");

		write(logMessage);
	}

	public static void init() {
		List<String> initMessage = new ArrayList<String>();
		initMessage.add("Jack log: on " + getTime());
		initMessage.add("Hi! I'm Jack: Application is running");
		initMessage.add("");

		write(initMessage);
	}

	public static void writeError(int status, String from, String message) {
		List<String> errorMessage = new ArrayList<String>();
		errorMessage.add("Jack log: on " + getTime());
		errorMessage.add("Jack status: " + status);
		errorMessage.add("Jack from: " + from);
		errorMessage.add("Jack error: " + message);
		errorMessage.add("");
	}

	private static void write(List<String> logMessage) {
		try {
			File log = new File(PathResolve.getPath("\\src\\Debug\\log.txt"));

			if (!log.exists()) log.createNewFile();

				Files.write(Paths.get(log.getPath()), logMessage, StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	private static String getTime() {
		LocalDateTime now = LocalDateTime.now();
		String myDate = "[" + now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		myDate += "] - " + now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		return myDate;
	}

}
