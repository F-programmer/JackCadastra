package Journeys.Admin.Interfaces;

import Components.Navigation.Navbar;
import Components.Navigation.Navitem;
import Components.Navigation.Navmenu;
import Components.UI.DefaultLabel;
import Data.UserInterface;
import Generic.DefaultScreen;
import Journeys.Admin.Interfaces.Delete.DeleteUsers;
import Utils.Colors;
import Utils.PropsFormatter;
import Utils.Screens;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends DefaultScreen {

	private static final long serialVersionUID = 1L;

	JMenuBar menubar;

	JLabel lblTotalUsuarios;
	JLabel totalUsuarios;
	JLabel lblTotalAdmins;
	JLabel totalAdmins;

	public Home() throws Exception {
		super(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Home - Administrador");

		HashMap<Object, Object> defaultItemsProps = new HashMap<Object, Object>();
		HashMap<Object, Object> defaultMenuProps = new HashMap<Object, Object>();

		Navitem niCadUser = new Navitem();
		niCadUser.addProps(defaultItemsProps, "Clientes");
		niCadUser.openScreen("screenAdminCadUser");
		Navitem niCadAdmin = new Navitem();
		niCadAdmin.addProps(defaultItemsProps, "Administradores");
		niCadAdmin.openScreen("screenAdminPromoveUser");

		Navmenu nmCad = new Navmenu();
		nmCad.addProps(defaultMenuProps, "Cadastrar");
		nmCad.addItem(niCadUser.init());
		nmCad.addItem(niCadAdmin.init());

		Navitem niConsUser = new Navitem();
		niConsUser.addProps(defaultItemsProps, "Clientes");
		Navitem niConsAdmin = new Navitem();
		niConsAdmin.addProps(defaultItemsProps, "Administradores");

		Navmenu nmCons = new Navmenu();
		nmCons.addProps(defaultMenuProps, "Consultar");
		nmCons.addItem(niConsUser.init());
		nmCons.addItem(niConsAdmin.init());

		Navitem niDelUser = new Navitem();
		niDelUser.addProps(defaultItemsProps, "Usuários");
		JMenuItem niDelUserMenuItem = niDelUser.init();
		niDelUserMenuItem.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					((DeleteUsers) Screens.get("screenDeleteUser")).updateTable();
					((JFrame) Screens.get("screenDeleteUser")).setVisible(true);
				}
			}
		);

		Navmenu nmDel = new Navmenu();
		nmDel.addProps(defaultMenuProps, "Deletar");
		nmDel.addItem(niDelUserMenuItem);

		Navitem niUpdUser = new Navitem();
		niUpdUser.addProps(defaultItemsProps, "Clientes");
		Navitem niUpdAdmin = new Navitem();
		niUpdAdmin.addProps(defaultItemsProps, "Administradores");

		Navmenu nmUpd = new Navmenu();
		nmUpd.addProps(defaultMenuProps, "Atualizar");
		nmUpd.addItem(niUpdUser.init());
		nmUpd.addItem(niUpdAdmin.init());

		Navitem niAccountDados = new Navitem();
		Navitem niAccountPermissions = new Navitem();
		niAccountPermissions.addProps(defaultItemsProps, "Permissões");
		Navitem niAccountPendences = new Navitem();
		niAccountPendences.addProps(defaultItemsProps, "Pendências");
		Navitem niAccountLogout = new Navitem();
		niAccountLogout.addProps(defaultItemsProps, "Logout");

		Navmenu nmAccount = new Navmenu();
		nmAccount.addProps(defaultMenuProps, "Conta");
		nmAccount.addItem(niAccountDados.init());
		nmAccount.addItem(niAccountPermissions.init());
		nmAccount.addItem(niAccountPendences.init());
		nmAccount.addItem(niAccountLogout.init());

		HashMap<Object, Object> navbarProps = new HashMap<Object, Object>();
		navbarProps.put("position", PropsFormatter.position(0, 0, 600, 50));
		Navbar navbar = new Navbar(5);
		navbar.addProps(navbarProps);
		navbar.setMenu(nmCad.init());
		navbar.setMenu(nmCons.init());
		navbar.setMenu(nmDel.init());
		navbar.setMenu(nmUpd.init());
		navbar.setMenu(nmAccount.init());

		this.menubar = navbar.init();

		HashMap<Object, Object> lblTotalUsuariosProps = new HashMap<Object, Object>();
		lblTotalUsuariosProps.put(
			"position",
			PropsFormatter.position(
				50,
				250,
				250,
				PropsFormatter.getFormPaddingLetter() + PropsFormatter.getLetterHeight()
			)
		);
		lblTotalUsuariosProps.put("text", "Total de Usuários: ");
		lblTotalUsuariosProps.put("subtitleLabel", "true");
		this.lblTotalUsuarios = new DefaultLabel().addProps(lblTotalUsuariosProps);

		HashMap<Object, Object> totalUsuariosProps = new HashMap<Object, Object>();
		totalUsuariosProps.put(
			"position",
			PropsFormatter.position(
				100,
				270 +
				PropsFormatter.getFormPaddingLetter() +
				PropsFormatter.getLetterHeight(),
				250,
				PropsFormatter.getFormPaddingLetter() + PropsFormatter.getLetterHeight()
			)
		);
		totalUsuariosProps.put(
			"text",
			String.valueOf(UserInterface.getCountUsers())
		);
		totalUsuariosProps.put("h1Label", "true");
		totalUsuariosProps.put("textColor", "auxiliar");
		this.totalUsuarios = new DefaultLabel().addProps(totalUsuariosProps);

		HashMap<Object, Object> lblTotalAdminsProps = new HashMap<Object, Object>();
		lblTotalAdminsProps.put(
			"position",
			PropsFormatter.position(
				50,
				400,
				250,
				PropsFormatter.getFormPaddingLetter() + PropsFormatter.getLetterHeight()
			)
		);
		lblTotalAdminsProps.put("text", "Total de Administradores: ");
		lblTotalAdminsProps.put("subtitleLabel", "true");
		this.lblTotalAdmins = new DefaultLabel().addProps(lblTotalAdminsProps);

		HashMap<Object, Object> totalAdminsProps = new HashMap<Object, Object>();
		totalAdminsProps.put(
			"position",
			PropsFormatter.position(
				100,
				420 +
				PropsFormatter.getFormPaddingLetter() +
				PropsFormatter.getLetterHeight(),
				250,
				PropsFormatter.getFormPaddingLetter() + PropsFormatter.getLetterHeight()
			)
		);
		totalAdminsProps.put(
			"text",
			String.valueOf(UserInterface.getCountAdmins())
		);
		totalAdminsProps.put("h1Label", "true");
		totalAdminsProps.put("textColor", "auxiliar");
		this.totalAdmins = new DefaultLabel().addProps(totalAdminsProps);

		Container container = this.getContentPane();
		container.add(this.menubar);
		container.setBackground(Colors.get("terciary"));

		container.add(this.lblTotalAdmins);
		container.add(this.totalAdmins);
		container.add(this.lblTotalUsuarios);
		container.add(this.totalUsuarios);
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
}
