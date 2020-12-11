package Utils;

public class PathResolve {

	public static String getPath(String filePath) {
		String absolutePath = System.getProperty("user.dir") + filePath;
		return absolutePath;
	}
}
