package Components.UI;

import Utils.Colors;
import Utils.Fonts;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DefaultTable {

	private JTable table;

	public DefaultTable() {
		this.table = new JTable();
		this.table.setBackground(Colors.get("primary"));
	}

	public JTable addProps() {
		return this.table;
	}

	public static DefaultTableCellRenderer getDefaultCellRenderer() {
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public void setValue(Object value) {
				setForeground(Colors.get("textDark"));
				setHorizontalAlignment(CENTER);
				setFont(Fonts.get("primary", 16));
				setBackground(Colors.get("light"));
				super.setValue(value);
			}
		};
		return renderer;
	}

	public static DefaultTableCellRenderer getKeyCellRenderer() {
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public void setValue(Object value) {
				setBackground(Colors.get("terciary"));
				setForeground(Colors.get("text"));
				setHorizontalAlignment(CENTER);
				setFont(Fonts.get("primary", 16));
				super.setValue(value);
			}
		};
		return renderer;
	}

	public static DefaultTableCellRenderer getHeaderCellRenderer() {
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public void setValue(Object value) {
				setBackground(Colors.get("auxiliar"));
				setForeground(Colors.get("text"));
				setHorizontalAlignment(CENTER);
				setFont(Fonts.get("primary", 18));
				super.setValue(value);
			}
		};
		return renderer;
	}
}
