package Components.Groups.ComboLabel;

import Utils.PropsFormatter;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.UI.DefaultComboBox;
import Components.UI.DefaultLabel;

public class ComboLabel extends JPanel {

	private int panelWidth = 0;
	private int panelHeight = 0;

	private JLabel label;
	public JComboBox combo;

	public ComboLabel(
		int panelWidth,
		int panelHeight,
		String lblText,
		int lblWidth,
		int lblHeight,
		String[] comboItems,
		int comboWidth,
		int comboHeight
	) {
		HashMap labelProps = new HashMap();
		labelProps.put(
			"position",
			PropsFormatter.position(20, 10, lblWidth, lblHeight)
		);
		labelProps.put("text", lblText);

		HashMap comboProps = new HashMap();
		comboProps.put(
			"position",
			PropsFormatter.position(
				20, 10 + lblHeight * 2,
				comboWidth, comboHeight
				)
		);
		comboProps.put("values", comboItems);

		this.createElements(
			panelWidth,
			panelHeight,
			labelProps,
			comboProps
		);

		this.addElements();
	}

	public ComboLabel(
		int panelWidth,
		int panelHeight,
		String lblText,
		int lblWidth,
		int lblHeight,
		String[] comboItems,
		int comboWidth,
		int comboHeight,
		boolean outlined
	) {
		HashMap labelProps = new HashMap();
		labelProps.put(
			"position",
			PropsFormatter.position(20, 10, lblWidth, lblHeight)
		);
		labelProps.put("text", lblText);

		HashMap comboProps = new HashMap();
		comboProps.put(
			"position",
			PropsFormatter.position(
				20, 20 + lblHeight,
				comboWidth, comboHeight
				)
		);
		comboProps.put("values", comboItems);
		comboProps.put("backgroundColor", "text");

		this.createElements(
			panelWidth,
			panelHeight,
			labelProps,
			comboProps
		);

		this.addElements();
	}

	public void createElements(
		int panelWidth,
		int panelHeight,
		HashMap labelProps,
		HashMap comboProps
	) {
		this.setLayout(null);
		this.setBackground(null);
		this.setOpaque(true);
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;

		this.setSize(this.panelWidth, this.panelHeight);

		this.label = new DefaultLabel().addProps(labelProps);
		this.combo = new DefaultComboBox().addProps(comboProps);

	}

	public void addElements() {
		this.add(this.label);
		this.add(this.combo);
	}
	public void position(int x, int y) {
		this.setBounds(x, y, this.panelWidth, this.panelHeight);
	}

	public void reset() {
		this.combo.setSelectedItem(null);
	}
}
