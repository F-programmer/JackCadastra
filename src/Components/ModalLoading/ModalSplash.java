package Components.ModalLoading;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Animations.Splash;
import Components.UI.DefaultLabel;
import Utils.Colors;
import Utils.PropsFormatter;

public class ModalSplash extends JFrame{
	private JLabel lblTitulo;
	private JLabel lblSubTitulo;
	private JPanel splashAnimation;

	public ModalSplash() throws Exception {

		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		HashMap lblTituloProps = new HashMap();
		lblTituloProps.put("position", PropsFormatter.position(
			20,
			50,
			150,
			PropsFormatter.getLetterHeight() + PropsFormatter.getFormPaddingLetter())
		);
		lblTituloProps.put("text", "Carregando...");
		lblTituloProps.put("titleLabel", "true");
		lblTituloProps.put("textColor", "primary");
		this.lblTitulo = new DefaultLabel().addProps(lblTituloProps);

		HashMap lblSubTituloProps = new HashMap();
		lblSubTituloProps.put("position", PropsFormatter.position(
			20,
			50 + PropsFormatter.getLetterHeight() + PropsFormatter.getFormPaddingLetter(),
			200,
			PropsFormatter.getLetterHeight() + PropsFormatter.getFormPaddingLetter()
		));
		lblSubTituloProps.put("text", "Por favor, aguarde.");
		this.lblSubTitulo = new DefaultLabel().addProps(lblSubTituloProps);

		this.getContentPane().setBackground(Colors.get("modal"));

		this.splashAnimation = new Splash("\\src\\assets\\opcao1.png", 50, Colors.get("modal"));
		splashAnimation.setBounds(250, 25, 150, 150);
		((Splash) splashAnimation).kill();

		this.add(this.lblTitulo);
		this.add(this.lblSubTitulo);
		this.add(splashAnimation);
	}

	public void showLoading() {
		((Splash) this.splashAnimation).restore();
		this.setVisible(true);
	}

	public void hid() {
		((Splash) this.splashAnimation).kill();
		this.setVisible(false);
	}
}
