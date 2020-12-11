package Journeys.Admin.Interfaces.Delete;

import Components.Groups.InputLabel.InputLabel;
import Components.Messages.JOP;
import Components.ModalLoading.ModalSplash;
import Components.UI.DefaultButton;
import Components.UI.DefaultLabel;
import Data.UserInterface;
import Generic.DefaultScreen;
import Journeys.Admin.Components.TableUserAdmin.Table;
import Personas.Admin;
import Personas.User;
import Utils.Colors;
import Utils.Delayer;
import Utils.InitiApplication;
import Utils.PropsFormatter;
import Utils.Screens;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

public class DeleteUsers extends DefaultScreen {

	private static final long serialVersionUID = 1L;

	private JLabel titleLabel;
	private InputLabel fieldId;
	private InputLabel fieldName;
	private JButton btnPromove;
	private Table table;

	public DeleteUsers() throws Exception {
		super(600, 600);
		this.setTitle("Deletar Usuários");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		HashMap<Object, Object> titleLabelProps = new HashMap<Object, Object>();
		titleLabelProps.put(
			"position",
			PropsFormatter.position(50, 10, 250, PropsFormatter.getLetterHeight())
		);
		titleLabelProps.put("text", "Excluir Usuários!");
		titleLabelProps.put("titleLabel", "true");
		this.titleLabel = new DefaultLabel().addProps(titleLabelProps);

		this.fieldId = new InputLabel(100, 100, "ID: ", 100, 30, "", 80, 30, true);
		this.fieldId.position(10, 50);

		this.fieldName =
			new InputLabel(300, 100, "Nome: ", 100, 30, "", 280, 30, true);
		this.fieldName.position(120, 50);

		HashMap<Object, Object> btnPromoveProps = new HashMap<Object, Object>();
		btnPromoveProps.put("position", PropsFormatter.position(320, 40, 250, 50));
		btnPromoveProps.put("text", "Deletar Usuário");
		this.btnPromove = new DefaultButton().addProps(btnPromoveProps);
		this.btnPromove.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ModalSplash modalSplash;

						if (fieldId.input.getText().equals("")) {
							JOP.showAtencion("Selecione um usuário primeiro");
							return;
						}

						int idCliente = Integer.valueOf(fieldId.input.getText());

						try {
							modalSplash = new ModalSplash();
							modalSplash.showLoading();

							Delayer delayer = new Delayer() {
								public boolean exec() throws NumberFormatException, Exception {
									if (
										idCliente == Integer.valueOf(User.getInstance().getId())
									) {
										modalSplash.hid();
										JOP.showError("Você não pode deletar a si próprio!");
										return false;
									}

									if (
										JOP.showYNOption(
											"Tem certeza que deseja deletar o usuário?"
										)
									) {
										boolean status = UserInterface.deleteUser(idCliente);
										if (status) {
											modalSplash.hid();
											JOP.showMessage("Usuário deletado com sucesso!");
											if (!JOP.showYNOption("Deseja deletar mais usuários?")) {
												setVisible(false);
												((JFrame) Screens.get("screenAdminHome")).setVisible(
														true
													);
											} else {}
											int rowNumber = table.getRowAtValueInColumn(
												0,
												fieldId.input.getText()
											);
											updateTable();
											table.deleteRowAt(rowNumber);
										} else {
											modalSplash.hid();
											JOP.showError("Houve um erro ao deletar o usuário!");
										}
									} else {
										modalSplash.hid();
										JOP.showMessage("Usuário poupado!");
									}
									return false;
								}
							};
							delayer.create(1500);
							updateTable();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			);
		this.table = new Table(600, 400);

		List<List<String>> query = UserInterface.getAllUsersNotAdmin();

		List<Admin> values = new ArrayList<Admin>();

		for (List<String> queryLine : query) {
			values.add(
				new Admin(
					queryLine.get(0),
					queryLine.get(1),
					queryLine.get(2),
					queryLine.get(3).equals("true") ? true : false
				)
			);
		}
		this.table.setTableValues(values);

		MouseListener onTableClick = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JTable target = (JTable) e.getSource();
				int row = target.getSelectedRow();

				fieldId.input.setText((String) target.getValueAt(row, 0));
				fieldName.input.setText((String) target.getValueAt(row, 1));
			}
		};

		this.table.addClickEvent(onTableClick);

		this.table.setBounds(20, 150, 540, 400);

		Container container = this.getContentPane();
		container.setBackground(Colors.get("primary"));

		container.add(this.titleLabel);
		container.add(this.fieldId);
		container.add(this.fieldName);
		container.add(this.btnPromove);
		container.add(this.table);
	}

	public void updateTable() {
		try {
			// this.table.clear();

			List<List<String>> query = UserInterface.getAllUsersNotAdmin();

			List<Admin> values = new ArrayList<Admin>();

			for (List<String> queryLine : query) {
				values.add(
					new Admin(
						queryLine.get(0),
						queryLine.get(1),
						queryLine.get(2),
						queryLine.get(3).equals("true") ? true : false
					)
				);
			}

			this.table.updateValues(values);
		} catch (Exception e) {}
	}

	public static void main(String[] args) throws Exception {
		InitiApplication.init();

		new DeleteUsers().setVisible(true);
	}
}
