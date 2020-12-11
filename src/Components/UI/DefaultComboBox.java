package Components.UI;

import Utils.*;
import java.util.HashMap;
import javax.swing.*;

public class DefaultComboBox {

	private JComboBox cbSelect = new JComboBox();

	public DefaultComboBox() {
		this.cbSelect.setBackground(Colors.get("background"));
		this.cbSelect.setForeground(Colors.get("primary"));
		this.cbSelect.setFont(Fonts.get("primary", 16));
	}

	public JComboBox addProps(HashMap props) {
		// default prop
		if (props.containsKey("position")) {
			HashMap postion = (HashMap) props.get("position");
			this.cbSelect.setBounds(
					(int) postion.get("x"),
					(int) postion.get("y"),
					(int) postion.get("width"),
					(int) postion.get("height")
				);
		}
		// only combo props
		if (props.containsKey("placeholder") && props.containsKey("bordered")) {
			this.cbSelect.setBorder(
					BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Colors.get("primary")),
						(String) props.get("placeholder")
					)
				);
		}
		if (props.containsKey("outline")) {
			this.cbSelect.setBorder(
					BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.get("text"))
				);
			this.cbSelect.setBackground(null);
			this.cbSelect.setOpaque(false);
		}
		if (props.containsKey("backgroundColor")) {
			this.cbSelect.setBackground(
					Colors.get((String) props.get("backgroundColor"))
				);
		}
		if (props.containsKey("values")) {
			String[] values = (String[]) props.get("values");
			this.cbSelect.setEditable(true);
			for (String value : values) this.cbSelect.addItem(value);
			this.cbSelect.setEditable(false);
		}

		this.cbSelect.setSelectedItem(null);

		return this.cbSelect;
	}
}
