package Components.Calendar;

import javax.swing.JFrame;

import Modules.EVCalendar.code.Dia;
import Modules.EVCalendar.code.DiaSemana;
import Modules.EVCalendar.code.EVCalendar;
import Modules.EVCalendar.code.EstiloDia;
import Modules.EVCalendar.code.IActionEVCalendar;
import Utils.Colors;

public class Calendar extends JFrame implements IActionEVCalendar{
	EVCalendar calendario;
	EstiloDia e;
	public Calendar(){
		setSize(600, 700);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Colors.get("modal"));

		calendario = new EVCalendar();
		calendario.setBounds(0,0, getWidth(), getHeight() - 50);
		calendario.setActionEVCalendar(this);
		calendario.setBackground(Colors.get("modal"));
		add(calendario);
		setLayout(null);
		setLocationRelativeTo(null);
		calendario.mudarCorDaSemana(DiaSemana.DOMINGO, Colors.get("auxiliar"));
		new Thread(new Runnable() {

			public void run() {
				while(true){
					try {
						Thread.sleep(50l);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					calendario.setSize(getWidth(), getHeight() - 50);
				}
			}
		}).start();
	}
	//doubleClickedDay
	public void doubleClickedDay(Dia dia) {
	}

	public void clickedDay(Dia dia) {
		Dia d = new Dia();
		d.setDia(dia.getDia());
		d.setMes(dia.getMes());
		d.setAno(dia.getAno());
		calendario.removerAgendamento(d);
		calendario.mudarCorDaSemana(DiaSemana.DOMINGO, Colors.get("auxiliar"));
		DataValues.setData(d);
		this.setVisible(false);
	}
	public void mouseEnteredDay(Dia dia) {

		if(!calendario.isAgendado(dia)){
			EstiloDia e =dia.getEstilo();
			e.setCorFundo(Colors.get("secondary"));
			calendario.mudarCorDaSemana(DiaSemana.DOMINGO, Colors.get("auxiliar"));
			dia.setEstilo(e);
		}
//		calendario.mudarCorDaSemana(DiaSemana.DOMINGO, Color.pink);

	}
	public void mouseExited(Dia dia) {
		if(!calendario.isAgendado(dia)){
			calendario.mudarCorDaSemana(DiaSemana.DOMINGO, Colors.get("auxiliar"));
			dia.setEstilo(EstiloDia.getEstiloPadrao());
		}
//		calendario.mudarCorDaSemana(DiaSemana.DOMINGO, Color.pink);

	}
}

