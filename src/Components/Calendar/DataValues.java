package Components.Calendar;

import Modules.EVCalendar.code.Dia;

public class DataValues {
	private static int dia = 0;
	private static int mes = 0;
	private static int ano = 0;

	public static void setData(Dia d) {
		dia = d.getDia();
		mes = d.getMes();
		ano = d.getAno();
	}

	public static int getDia() {
		return dia;
	}
	public static int getMes() {
		return mes;
	}
	public static int getAno() {
		return ano;
	}

	public static void reset() {
		dia = 0;
		mes = 0;
		ano = 0;
	}
}
