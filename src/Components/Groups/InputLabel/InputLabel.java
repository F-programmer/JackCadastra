package Components.Groups.InputLabel;

import Components.UI.DefaultInput;
import Components.UI.DefaultLabel;
import Utils.PropsFormatter;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputLabel extends JPanel {

	private int panelWidth = 0;
	private int panelHeight = 0;

	private JLabel label;
	public JTextField input;

	public InputLabel(
		int panelWidth,
		int panelHeight,
		String lblText,
		int lblWidth,
		int lblHeight,
		String inputPlaceholder,
		int inputWidth,
		int inputHeight
	) {

		HashMap labelProps = new HashMap();
		labelProps.put(
			"position",
			PropsFormatter.position(20, 10, lblWidth, lblHeight)
		);
		labelProps.put("text", lblText);

		HashMap inputProps = new HashMap();
		inputProps.put(
			"position",
			PropsFormatter.position(20, 20 + lblHeight, inputWidth, inputHeight)
		);
		inputProps.put("placeholder", inputPlaceholder);

		this.createElement(
				panelWidth,
				panelHeight,
				labelProps,
				inputProps
			);

		this.addElements();
	}

	public InputLabel(
		int panelWidth,
		int panelHeight,
		String lblText,
		int lblWidth,
		int lblHeight,
		String inputPlaceholder,
		int inputWidth,
		int inputHeight,
		boolean outlined
	) {

		HashMap labelProps = new HashMap();
		labelProps.put(
			"position",
			PropsFormatter.position(20, 10, lblWidth, lblHeight)
		);
		labelProps.put("text", lblText);

		HashMap inputProps = new HashMap();
		inputProps.put(
			"position",
			PropsFormatter.position(20, 20 + lblHeight, inputWidth, inputHeight)
		);
		inputProps.put("placeholder", inputPlaceholder);

		if (outlined) inputProps.put("outline", "true");

		this.createElement(
				panelWidth,
				panelHeight,
				labelProps,
				inputProps
			);

		this.addElements();
	}

	private void createElement(
		int panelWidth,
		int panelHeight,

		HashMap labelProps,
		HashMap inputProps
	) {
		this.setLayout(null);
		this.setBackground(null);
		this.setOpaque(true);
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;

		this.setSize(this.panelWidth, this.panelHeight);

		this.label = new DefaultLabel().addProps(labelProps);

		this.input = new DefaultInput().addProps(inputProps);
	}

	private void addElements() {
		this.add(this.label);
		this.add(this.input);
	}

	public void position(int x, int y) {
		this.setBounds(x, y, this.panelWidth, this.panelHeight);
	}

	public void reset() {
		this.input.setText("");
	}
}
