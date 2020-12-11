package Components.Groups.DataLabel;

import Components.Calendar.*;
import Components.UI.DefaultButton;
import Components.UI.DefaultLabel;
import Utils.Delayer;
import Utils.PropsFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DataLabel extends JPanel {

	private int panelWidth = 0;
	private int panelHeight = 0;

	private JLabel label;
	public JButton data;

	public DataLabel(
		int panelWidth,
		int panelHeight,
		String lblText,
		int lblWidth,
		int lblHeight
	) {
		HashMap labelProps = new HashMap();
		labelProps.put(
			"position",
			PropsFormatter.position(20, 10, lblWidth, lblHeight)
		);
		labelProps.put("text", lblText);

		HashMap dataProps = new HashMap();
		dataProps.put(
			"position",
			PropsFormatter.position(20, 20 + lblHeight, 120, lblHeight)
		);
		dataProps.put("fakeInput", "true");

		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;

		this.createElement(labelProps, dataProps);
		this.addElements();
	}

	private void createElement(HashMap labelProps, HashMap dataProps) {
		this.setLayout(null);
		this.setBackground(null);
		this.setOpaque(false);

		this.setSize(this.panelWidth, this.panelHeight);

		this.label = new DefaultLabel().addProps(labelProps);

		this.data = new DefaultButton().addProps(dataProps);
		this.data.setText("dd/mm/aaaa");
		this.data.setHorizontalTextPosition(SwingConstants.LEFT);
		this.data.setHorizontalAlignment(SwingConstants.LEFT);
		data.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						DataChoose.getInstance().openCalendar();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					Delayer delayer = new Delayer() {
						@Override
						public boolean exec() throws Exception {
							if (DataChoose.isOpen()) {
								return false;
							} else {
								if (
									DataValues.getDia() == 0 ||
									DataValues.getMes() == 0 ||
									DataValues.getAno() == 0
								) {
									return false;
								} else {
									data.setText(
										DataValues.getDia() +
										"/" +
										DataValues.getMes() +
										"/" +
										DataValues.getAno()
									);
									DataValues.reset();
									return true;
								}
							}
						}
					};

					try {
						delayer.repeatUntil(1000);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		);
	}

	private void addElements() {
		this.add(this.label);
		this.add(this.data);
	}

	public void position(int x, int y) {
		this.setBounds(x, y, this.panelWidth, this.panelHeight);
	}

	public void reset() {
		this.data.setText("dd/mm/aaaa");
	}
}
