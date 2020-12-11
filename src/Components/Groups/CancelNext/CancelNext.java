package Components.Groups.CancelNext;

import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import Components.UI.DefaultButton;
import Utils.PropsFormatter;

public class CancelNext extends JPanel {

	private int panelWidth = 0;
	private int panelHeight = 0;

	private JButton next;
	private JButton cancel;

	public CancelNext(
		int panelWidth,
		int panelHeight,
		String nextText,
		int nextWidth,
		int nextHeight,
		String cancelText,
		int cancelWidth,
		int cancelHeight
	) {

		panelWidth += 20;
		panelHeight += 20;

		HashMap nextProps = new HashMap();
		nextProps.put("text", nextText);
		nextProps.put("position", PropsFormatter.position(panelWidth - 10 - nextWidth, 10, nextWidth, nextHeight));
		nextProps.put("nextButton", "true");

		HashMap cancelProps = new HashMap();
		cancelProps.put("text", cancelText);
		cancelProps.put("position", PropsFormatter.position(10, 10, nextWidth, nextHeight));
		cancelProps.put("cancelButton", "true");

		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;

		this.createElements(nextProps, cancelProps);
		this.next.setSize(nextWidth, nextHeight);
		this.addElements();
	}

	private void createElements(
		HashMap nextProps,
		HashMap cancelProps
	) {
		this.next = new DefaultButton().addProps(nextProps);
		this.cancel = new DefaultButton().addProps(cancelProps);
	}

	private void addElements() {
		this.setSize(this.panelWidth, this.panelHeight);
		this.setLayout(null);

		this.add(this.next);
		this.add(this.cancel);
	}

	public void addActions(
		ActionListener actionNext,
		ActionListener actionCancel
	) {
		this.next.addActionListener(actionNext);
		this.cancel.addActionListener(actionCancel);
	}

	public void position(int x, int y) {
		this.setBounds(x, y, this.panelWidth, this.panelHeight);
	}
}
