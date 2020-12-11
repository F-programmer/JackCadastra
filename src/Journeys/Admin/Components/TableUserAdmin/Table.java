package Journeys.Admin.Components.TableUserAdmin;

import Components.UI.DefaultTable;
import Personas.Admin;
import Utils.Colors;
import java.awt.event.*;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable table;
	private Model model;

	private int width = 0;
	private int height = 0;

	public Table(int width, int height) throws Exception {
		this.width = width;
		this.height = height;

		this.setSize(this.width, this.height);
		this.setLayout(null);
	}

	public void setTableValues(List<Admin> values) {
		this.model = new Model(values);

		this.table = new DefaultTable().addProps();
		this.table.setModel(model);
		for (int i = 1; i < table.getColumnCount(); i++) {
			this.table.getColumnModel()
				.getColumn(i)
				.setCellRenderer(DefaultTable.getDefaultCellRenderer());
			this.table.getColumnModel()
				.getColumn(i)
				.setHeaderRenderer(DefaultTable.getHeaderCellRenderer());
		}
		this.table.getColumnModel()
			.getColumn(0)
			.setCellRenderer(DefaultTable.getKeyCellRenderer());
		this.table.getColumnModel()
			.getColumn(0)
			.setHeaderRenderer(DefaultTable.getHeaderCellRenderer());

		this.table.setBackground(Colors.get("light"));

		JScrollPane scroll = new JScrollPane(this.table);
		scroll.setBounds(0, 0, this.width - 40, this.height);

		this.add(scroll);
	}

	public void addClickEvent(MouseListener evt) {
		this.table.addMouseListener(evt);
	}

	public void clear() {
		if (this.table != null) this.table.removeAll();
	}

	public JTable getTable() {
		return this.table;
	}

	public int getRowAtValueInColumn(int column, String compareValue) {
		String[] columns = ((Model) this.table.getModel()).getColumnAt(column);

		for (int i = 0; i < columns.length; i++) {
			if (columns[i].equals(compareValue)) return i;
		}

		return 0;
	}

	public void updateValues(List<Admin> values) {
		for (int i = 0; i < values.size(); i++) {
			this.table.setValueAt(values.get(i).getId(), i, 0);
			this.table.setValueAt(values.get(i).getNome(), i, 1);
			this.table.setValueAt(values.get(i).getCpf(), i, 2);
			this.table.setValueAt(values.get(i).getIsAdmin(), i, 3);
		}
	}

	public void deleteRowAt(int row) {
		((Model) this.table.getModel()).removeRow(row);
	}
}
