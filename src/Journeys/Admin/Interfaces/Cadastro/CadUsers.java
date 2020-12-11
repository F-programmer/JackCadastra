package Journeys.Admin.Interfaces.Cadastro;

import Components.Groups.CancelNext.CancelNext;
import Components.Groups.ComboLabel.ComboLabel;
import Components.Groups.DataLabel.DataLabel;
import Components.Groups.InputLabel.InputLabel;
import Components.Groups.PasswordLabel.PasswordLabel;
import Components.Messages.JOP;
import Components.ModalLoading.ModalSplash;
import Components.UI.ScreenBackground;
import Data.UserInterface;
import Debug.Components.Jack;
import Generic.DefaultScreen;
import Journeys.Admin.Interfaces.Delete.DeleteUsers;
import Utils.Colors;
import Utils.Delayer;
import Utils.Formatter;
import Utils.InitiApplication;
import Utils.Screens;
import Utils.ValidFields;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;

public class CadUsers extends DefaultScreen {

	private static final long serialVersionUID = 1L;

	public CadUsers() throws IOException {
		super(700, 700);
		this.setTitle("Cadastro de Clientes");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		ScreenBackground background = new ScreenBackground();
		background.setStretched(false);
		background.init("../../assets/cadastro.png");

		InputLabel painelNome = new InputLabel(
			400,
			120,
			"Nome: ",
			100,
			30,
			"Ex: Jack",
			375,
			30,
			true
		);
		painelNome.position(75, 50);
		painelNome.setOpaque(false);

		String[] sexos = { "Masculino", "Feminino", "Outro" };
		ComboLabel painelSexo = new ComboLabel(
			200,
			120,
			"Sexo: ",
			100,
			30,
			sexos,
			110,
			30,
			true
		);
		painelSexo.position(485, 50);
		painelSexo.setOpaque(false);

		DataLabel painelData = new DataLabel(
			200,
			100,
			"Data de Nascimento: ",
			180,
			30
		);
		painelData.position(75, 150);

		InputLabel painelRg = new InputLabel(
			180,
			120,
			"RG: ",
			100,
			30,
			"EX: 000.000-00",
			150,
			30,
			true
		);
		painelRg.position(75 + 190, 150);
		painelRg.setOpaque(false);

		InputLabel painelCpf = new InputLabel(
			200,
			120,
			"CPF: ",
			100,
			30,
			"EX: 000.000.000-00",
			180,
			30,
			true
		);
		painelCpf.position(75 + 200 + 160, 150);
		painelCpf.setOpaque(false);

		InputLabel painelEndereco = new InputLabel(
			270,
			120,
			"Endereço: ",
			100,
			30,
			"EX: Rua Atalaialeste",
			250,
			30,
			true
		);
		painelEndereco.position(75, 250);
		painelEndereco.setOpaque(false);

		InputLabel painelNumero = new InputLabel(
			120,
			120,
			"Número: ",
			100,
			30,
			"EX: 12345",
			80,
			30,
			true
		);
		painelNumero.position(75 + 270, 250);
		painelNumero.setOpaque(false);

		String[] ufs = {
			"AL",
			"AP",
			"AM",
			"BA",
			"CE",
			"DF",
			"ES",
			"GO",
			"MA",
			"MT",
			"MS",
			"MG",
			"PA",
			"PB",
			"PR",
			"PE",
			"PI",
			"RJ",
			"RN",
			"RS",
			"RO",
			"RR",
			"SC",
			"SP",
			"SE",
			"TO",
		};
		ComboLabel painelUf = new ComboLabel(
			120,
			120,
			"UF: ",
			100,
			30,
			ufs,
			100,
			30,
			true
		);
		painelUf.position(75 + 270 + 120, 250);
		painelUf.setOpaque(false);

		InputLabel painelCidade = new InputLabel(
			260,
			120,
			"Cidade: ",
			100,
			30,
			"EX: São Paulo",
			240,
			30,
			true
		);
		painelCidade.position(75, 350);
		painelCidade.setOpaque(false);

		InputLabel painelBairro = new InputLabel(
			260,
			120,
			"Bairro: ",
			100,
			30,
			"EX: Cidade Tiradentes",
			240,
			30,
			true
		);
		painelBairro.position(75 + 260, 350);
		painelBairro.setOpaque(false);

		InputLabel painelEmail = new InputLabel(
			300,
			120,
			"Email: ",
			100,
			30,
			"Ex: example@mail.com",
			280,
			30,
			true
		);
		painelEmail.position(75, 430);
		painelEmail.setOpaque(false);

		PasswordLabel painelSenha = new PasswordLabel(
			260,
			120,
			"Senha: ",
			100,
			30,
			"",
			240,
			30,
			true
		);
		painelSenha.position(375, 430);
		painelSenha.setOpaque(false);

		InputLabel painelTelefone = new InputLabel(
			300,
			120,
			"Telefone: ",
			100,
			30,
			"Ex: 11 91234-5678",
			280,
			30,
			true
		);
		painelTelefone.position(75, 510);
		painelTelefone.setOpaque(false);

		CancelNext painelButtons = new CancelNext(
			550,
			50,
			"Avançar",
			100,
			30,
			"Cancelar",
			240,
			30
		);
		painelButtons.position(75, 590);
		painelButtons.setOpaque(false);
		ActionListener nextAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame modalSplash;
				try {
					modalSplash = new ModalSplash();
					((ModalSplash) modalSplash).showLoading();

					Delayer delayer = new Delayer() {
						public boolean exec() {
							try {
								if (
									painelCpf.input.getText().length() == 14 &&
									!painelData.data.getText().equals("dd/mm/aaaa") &&
									ValidFields.valid(painelNome.input.getText()) &&
									ValidFields.valid(painelRg.input.getText()) &&
									ValidFields.valid(painelCpf.input.getText()) &&
									ValidFields.valid(painelEndereco.input.getText()) &&
									ValidFields.valid(painelNumero.input.getText()) &&
									ValidFields.valid(painelCidade.input.getText()) &&
									ValidFields.valid(painelBairro.input.getText()) &&
									ValidFields.valid(painelEmail.input.getText()) &&
									ValidFields.valid(painelTelefone.input.getText()) &&
									ValidFields.valid(painelData.data.getText()) &&
									ValidFields.valid(
										(painelSenha.input.getPassword()).toString()
									) &&
									painelSexo.combo.getSelectedItem() != null &&
									ValidFields.valid(
										(String) painelSexo.combo.getSelectedItem()
									) &&
									painelUf.combo.getSelectedItem() != null &&
									ValidFields.valid((String) painelUf.combo.getSelectedItem())
								) {
									String[] values = {
										painelNome.input.getText(),
										painelCpf.input.getText(),
										painelRg.input.getText(),
										Formatter.formatDate(painelData.data.getText()),
										(String) painelSexo.combo.getSelectedItem(),
										painelEndereco.input.getText() +
										" - " +
										painelNumero.input.getText(),
										painelBairro.input.getText(),
										painelCidade.input.getText(),
										(String) painelUf.combo.getSelectedItem(),
										painelEmail.input.getText(),
										String.valueOf(painelSenha.input.getPassword()),
										painelTelefone.input.getText(),
									};

									boolean state = UserInterface.userRegistrer(values);

									if (state) {
										JOP.showMessage("Cliente cadastrado!");
										Jack.writeLog(201, "User registered");

										boolean repeat = JOP.showYNOption(
											"Deseja cadastrar outro usuário?"
										);

										if (repeat) {
											painelNome.reset();
											painelRg.reset();
											painelCpf.reset();
											painelEndereco.reset();
											painelNumero.reset();
											painelCidade.reset();
											painelBairro.reset();
											painelEmail.reset();

											painelData.reset();

											painelSenha.reset();

											painelSexo.reset();
											painelUf.reset();
										} else {
											(
												(DeleteUsers) Screens.get("screenDeleteUser")
											).updateTable();
											hidScreen();
											((JFrame) Screens.get("screenAdminHome")).setVisible(
													true
												);
										}
										(
											(DeleteUsers) Screens.get("screenDeleteUser")
										).updateTable();
									} else {
										JOP.showError("Fail on try register user");
										Jack.writeError(406, "user register", "request failed");
									}
									((ModalSplash) modalSplash).hid();
								} else {
									((ModalSplash) modalSplash).hid();

									JOP.showAtencion(
										"Preencha todos os campos\nNão utilize caracteres especiais"
									);
								}
							} catch (Exception e1) {
								e1.printStackTrace();
								Jack.writeError(500, "user register screen", e1.getMessage());
							}

							return true;
						}
					};

					delayer.create(3000);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		};

		ActionListener cancelAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painelNome.reset();
				painelRg.reset();
				painelCpf.reset();
				painelEndereco.reset();
				painelNumero.reset();
				painelCidade.reset();
				painelBairro.reset();
				painelEmail.reset();

				painelData.reset();

				painelSenha.reset();

				painelSexo.reset();
				painelUf.reset();
			}
		};

		painelButtons.addActions(nextAction, cancelAction);

		this.setContentPane(background);
		Container container = this.getContentPane();
		container.setBackground(Colors.get("textDark"));
		container.add(painelNome);
		container.add(painelSexo);
		container.add(painelData);
		container.add(painelRg);
		container.add(painelCpf);
		container.add(painelEndereco);
		container.add(painelNumero);
		container.add(painelUf);
		container.add(painelCidade);
		container.add(painelBairro);
		container.add(painelEmail);
		container.add(painelSenha);
		container.add(painelTelefone);
		container.add(painelButtons);
	}

	public void hidScreen() {
		this.setVisible(false);
	}

	public static void main(String[] args) throws Exception {
		InitiApplication.init();
		((JFrame) Screens.get("screenAdminCadUser")).setVisible(true);
	}
}
