package Generic;

import Components.Messages.JOP;
import Components.ModalLoading.ModalSplash;
import Components.UI.DefaultButton;
import Components.UI.DefaultInput;
import Components.UI.DefaultLabel;
import Components.UI.DefaultPassword;
import Components.UI.ScreenBackground;
import Data.UserInterface;
import Debug.Components.Jack;
import Personas.User;
import Utils.Delayer;
import Utils.PropsFormatter;
import Utils.Screens;
import Utils.ValidFields;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends DefaultScreen {

	private JLabel lblEmail;
	private JLabel lblSenha;

	private JTextField inputEmail;
	private JPasswordField inputSenha;

	private JButton btnLogin;
	private JButton btnCancel;

	private JFrame modalSplash = new ModalSplash();

	public Login(int width, int height) throws Exception {
		super(width, height);
		ScreenBackground painel = new ScreenBackground();
		painel.setStretched(false);
		painel.init("../../assets/login.png");

		this.setContentPane(painel);
		Container container = this.getContentPane();

		HashMap lblEmailProps = new HashMap();
		lblEmailProps.put(
			"position",
			PropsFormatter.position(40, 250, 250, PropsFormatter.getLetterHeight())
		);
		lblEmailProps.put("text", "Email");
		this.lblEmail = new DefaultLabel().addProps(lblEmailProps);
		HashMap inputEmailProps = new HashMap();
		inputEmailProps.put(
			"position",
			PropsFormatter.position(
				40,
				250 + PropsFormatter.getFormVSpacing(),
				200,
				PropsFormatter.getLetterHeight() + PropsFormatter.getFormPaddingLetter()
			)
		);
		inputEmailProps.put("placeholder", "Ex: exemplo@mail.com");
		inputEmailProps.put("bordered", true);
		inputEmailProps.put("outline", true);
		this.inputEmail = new DefaultInput().addProps(inputEmailProps);

		HashMap lblSenhaProps = new HashMap();
		lblSenhaProps.put(
			"position",
			PropsFormatter.position(350, 250, 250, PropsFormatter.getLetterHeight())
		);
		lblSenhaProps.put("text", "Senha");
		this.lblSenha = new DefaultLabel().addProps(lblSenhaProps);
		HashMap inputSenhaProps = new HashMap();
		inputSenhaProps.put(
			"position",
			PropsFormatter.position(
				350,
				250 + PropsFormatter.getFormVSpacing(),
				200,
				PropsFormatter.getLetterHeight() + PropsFormatter.getFormPaddingLetter()
			)
		);
		inputSenhaProps.put("placeholder", "Ex: 12345");
		inputSenhaProps.put("bordered", true);
		inputSenhaProps.put("outline", true);
		this.inputSenha = new DefaultPassword().addProps(inputSenhaProps);

		HashMap btnLoginProps = new HashMap();
		btnLoginProps.put(
			"position",
			PropsFormatter.position(
				600 - 150 - 80,
				300 +
				PropsFormatter.getFormVSpacing() +
				PropsFormatter.getFormPaddingLetter() +
				PropsFormatter.getLetterHeight(),
				150,
				15 +
				PropsFormatter.getFormPaddingLetter() +
				PropsFormatter.getLetterHeight()
			)
		);
		btnLoginProps.put("text", "Login");
		btnLoginProps.put("bordered", true);
		btnLoginProps.put("nextButton", true);
		this.btnLogin = new DefaultButton().addProps(btnLoginProps);

		HashMap btnCancelProps = new HashMap();
		btnCancelProps.put(
			"position",
			PropsFormatter.position(
				80,
				300 +
				PropsFormatter.getFormVSpacing() +
				PropsFormatter.getFormPaddingLetter() +
				PropsFormatter.getLetterHeight(),
				150,
				15 +
				PropsFormatter.getFormPaddingLetter() +
				PropsFormatter.getLetterHeight()
			)
		);
		btnCancelProps.put("text", "Cancelar");
		btnCancelProps.put("bordered", true);
		btnCancelProps.put("cancelButton", true);
		this.btnCancel = new DefaultButton().addProps(btnCancelProps);

		btnLogin.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (
							!(
								inputEmail.getText().equals("") &&
								String.valueOf(inputSenha.getPassword()).equals("")
							)
						) if (
							ValidFields.valid(inputEmail.getText()) &&
							ValidFields.valid(inputSenha.getText())
						) {
							boolean state;
							((ModalSplash) modalSplash).showLoading();
							state =
								UserInterface.login(inputEmail.getText(), inputSenha.getText());

							Delayer delayer = new Delayer() {
								@Override
								public boolean exec() throws Exception {
									((ModalSplash) modalSplash).hid();
									if (state) {
										Jack.writeLog(202, "login realized");
										String message =
											"Seja bem vindo(a) " +
											User.getInstance().getNome().split(" ")[0];
										if (User.getInstance().isAdmin()) message +=
											"\nVocê fez login como admin";
										JOP.showMessage(message);
										setVisible(false);
										((JFrame) Screens.get("screenAdminHome")).setVisible(true);
									} else {
										Jack.writeLog(203, "login failed");
										String message = "Houve um problema ao tentar fazer login";
										JOP.showError(message);
									}
									return true;
								}
							};
							delayer.create(2000);
						} else {
							JOP.showAtencion(
								"Preencha todos os campos\nNão utilize caracteres especiais"
							);
						}
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			}
		);

		HashMap propsNavbar = new HashMap();
		propsNavbar.put(
			"position",
			PropsFormatter.position(
				0,
				0,
				PropsFormatter.getLetterHeight() +
				PropsFormatter.getFormPaddingLetter(),
				width
			)
		);
		HashMap propsMenu = new HashMap();
		propsMenu.put("text", "Menu - 1");
		HashMap propsItem = new HashMap();
		propsItem.put("text", "Opção 1");

		container.add(this.lblEmail);
		container.add(this.inputEmail);

		container.add(this.lblSenha);
		container.add(this.inputSenha);

		container.add(this.btnLogin);
		container.add(this.btnCancel);
	}

	public void showScreen() {
		this.setVisible(true);
	}

	public void hidScreen() {
		this.setVisible(false);
	}

	public boolean stateScreen() {
		return this.isVisible();
	}

	public void tryLogin(String email, String senha) {}
}
