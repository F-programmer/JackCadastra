package Components.Navigation;

import javax.swing.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.GridLayout;

import Utils.*;

public class Navbar extends JFrame{
  private JMenuBar navbar = new JMenuBar();
  private ArrayList<JMenu> menus = new ArrayList<JMenu>();

  public Navbar(int collums) {
    this.navbar.setBackground(Colors.get("primary"));
		this.navbar.setLayout(new GridLayout(1, collums));
  }
  public JMenuBar addProps(HashMap props) {
    if (props.containsKey("position")) {
      HashMap postion = (HashMap) props.get("position");
      this.navbar.setBounds((int) postion.get("x"), (int) postion.get("y"), (int) postion.get("width"),
          (int) postion.get("height"));
    }
    if (props.containsKey("outline")) {
      this.navbar.setOpaque(false);
    }

    return this.navbar;
  }

  public void setMenu(JMenu menu) {
    menu.setForeground(Colors.get("text"));
    menu.setFont(Fonts.get("primary", 18));
    this.menus.add(menu);
  }

  public JMenuBar init() {
    for (JMenu menu : this.menus) {
      this.navbar.add(menu);
    }

    return this.navbar;
  }
}
