package Components.Messages;

import Utils.PathResolve;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JOP {

	public static void showMessage(String message) {
		JOptionPane.showMessageDialog(
			null,
			message,
			"Atenção!",
			JOptionPane.INFORMATION_MESSAGE,
			new ImageIcon(PathResolve.getPath("\\src\\Assets\\message.png"))
		);
	}

	public static void showError(String message) {
		JOptionPane.showMessageDialog(
			null,
			message,
			"Erro!",
			JOptionPane.ERROR_MESSAGE,
			new ImageIcon(PathResolve.getPath("\\src\\Assets\\error.png"))
		);
	}

	public static void showAtencion(String message) {
		JOptionPane.showMessageDialog(
			null,
			message,
			"Atenção!",
			JOptionPane.WARNING_MESSAGE,
			new ImageIcon(PathResolve.getPath("\\src\\Assets\\atencion.png"))
		);
	}

	public static boolean showYNOption(String message) {
		String[] options = { "Não", "Sim" };
		int selected = JOptionPane.showOptionDialog(
			null,
			message,
			"Pergunta!",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			new ImageIcon(PathResolve.getPath("\\src\\Assets\\question.png")),
			options,
			0
		);

		return selected == 1? true : false;
	}
}
