package Components.Navigation;

import Utils.Colors;
import Utils.Fonts;
import Utils.Screens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class Navitem extends JFrame {

	private static final long serialVersionUID = 1L;

	JMenuItem item = new JMenuItem();

	public Navitem() {
		this.item.setBackground(Colors.get("primary"));
		this.setForeground(Colors.get("auxiliar"));
		this.setFont(Fonts.get("primary", 18));
		this.item.setBorder(
				BorderFactory.createMatteBorder(2, 0, 0, 0, Colors.get("auxiliar"))
			);
	}

	public JMenuItem addProps(HashMap props) {
		return this.createItem(props);
	}

	public JMenuItem addProps(HashMap props, String title) {
		this.item = this.createItem(props);
		this.item.setText(title);
		return this.item;
	}

	public void openScreen(String screen) {
		this.item.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						((JFrame) Screens.get(screen)).setVisible(true);
					}
				}
			);
	}

	private JMenuItem createItem(HashMap props) {
		if (props.containsKey("position")) {
			HashMap postion = (HashMap) props.get("position");
			this.item.setBounds(
					(int) postion.get("x"),
					(int) postion.get("y"),
					(int) postion.get("width"),
					(int) postion.get("height")
				);
		}
		if (props.containsKey("outline")) {
			this.item.setOpaque(false);
		}

		if (props.containsKey("text")) {
			this.item.setText((String) props.get("text"));
		}

		return this.item;
	}

	public JMenuItem init() {
		return this.item;
	}
}
