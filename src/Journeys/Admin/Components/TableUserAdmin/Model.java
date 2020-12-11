package Journeys.Admin.Components.TableUserAdmin;

import Personas.Admin;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Model extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Admin> lines;
	private String[] collums = { "ID", "NOME", "CPF", "ISADMIN" };

	private static final int ID = 0;
	private static final int NOME = 1;
	private static final int CPF = 2;
	private static final int ISADMIN = 3;

	public Model(List<Admin> values) {
		this.lines = new ArrayList<Admin>(values);
	}

	@Override
	public int getRowCount() {
		return lines.size();
	}

	@Override
	public int getColumnCount() {
		return collums.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return collums[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case ID:
				return Integer.class;
			case NOME:
				return String.class;
			case CPF:
				return String.class;
			case ISADMIN:
				return Boolean.class;
			default:
				// Não deve ocorrer, pois só existem 4 colunas
				throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Admin line = lines.get(rowIndex);
		switch (columnIndex) {
			case ID:
				return line.getId();
			case NOME:
				return line.getNome();
			case CPF:
				return line.getCpf();
			case ISADMIN:
				return line.getIsAdmin() ? "SIM" : "NÃO";
			default:
				// Não deve ocorrer, pois só existem 4 colunas
				throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Pega o sócio referente a linha especificada.
		Admin line = lines.get(rowIndex);

		switch (columnIndex) {
			case ID:
				line.setId((String) aValue);
				break;
			case NOME:
				line.setNome((String) aValue);
				break;
			case CPF:
				line.setCpf((String) aValue);
				break;
			case ISADMIN:
				line.setIsAdmin((boolean) aValue);
				break;
			default:
				// Não deve ocorrer, pois só existem 4 colunas
				throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}

		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
	}

	public Admin getAdminAtRow(int rowIndex) {
		return lines.get(rowIndex);
	}

	public void addValue(Admin admin) {
		lines.add(admin);

		int lastIndex = this.getRowCount() - 1;
		// qual comeca, qual termina
		fireTableRowsInserted(lastIndex, lastIndex);
	}

	public void clear() {
		lines.clear();
		fireTableDataChanged();
	}

	public String[] getColumnAt(int column) {
		String[] values = new String[this.lines.size()];

		for (int i = 0; i < values.length; i++) {
			values[i] = (String) this.getValueAt(i, column);
		}

		return values;
	}

	public void removeRow(int row) {
		this.lines.remove(row);
		fireTableRowsDeleted(row, row);
	}
}
