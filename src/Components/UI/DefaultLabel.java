package Components.UI;

import Utils.*;
import java.util.HashMap;
import javax.swing.*;

public class DefaultLabel {

	private JLabel label = new JLabel();

	public DefaultLabel() {
		this.label.setFont(Fonts.get("primary", 16));
		this.label.setForeground(Colors.get("text"));
	}

	public JLabel addProps(HashMap props) {
		// only comboLabel props
		if (props.containsKey("position")) {
			HashMap postion = (HashMap) props.get("position");
			this.label.setBounds(
					(int) postion.get("x"),
					(int) postion.get("y"),
					(int) postion.get("width"),
					(int) postion.get("height")
				);
		}
		if (props.containsKey("textColor")) {
			this.label.setForeground(Colors.get((String) props.get("textColor")));
		}
		if (props.containsKey("backgroundColor")) {
			this.label.setBackground(
					Colors.get((String) props.get("backgroundColor"))
				);
		}
		if (props.containsKey("comboLabel")) {
			HashMap postion = (HashMap) props.get("position");
			this.label.setBounds(
					(int) postion.get("x") + 5,
					(int) postion.get("y") - 25,
					(int) postion.get("width"),
					(int) postion.get("height")
				);
		}
		if (props.containsKey("text")) {
			this.label.setText((String) props.get("text"));
		}
		if (props.containsKey("titleLabel")) {
			this.label.setFont(Fonts.get("primary", 20));
		}
		if (props.containsKey("subtitleLabel")) {
			this.label.setFont(Fonts.get("primary", 18));
		}
		if (props.containsKey("h1Label")) {
			this.label.setFont(Fonts.get("primary", 25));
		}
		if (props.containsKey("imagen")) {
			this.label.setIcon((ImageIcon) props.get("imagen"));
		}

		return this.label;
	}
}
