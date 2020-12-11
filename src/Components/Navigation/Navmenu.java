package Components.Navigation;

import javax.swing.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Color;
import java.awt.event.*;

import Utils.*;

public class Navmenu extends JFrame{

private JMenu nav = new JMenu();
  private ArrayList<JMenuItem> items = new ArrayList<JMenuItem>();

  public Navmenu() {
    this.nav.setBackground(Colors.get("primary"));
    this.setForeground(Colors.get("text"));
    this.setFont(Fonts.get("primary", 18));
  }
  public JMenu addProps(HashMap props) {
    return this.createMenu(props);
	}
	public JMenu addProps(HashMap props, String title) {
		this.nav = this.createMenu(props);
		this.nav.setText(title);
		return this.nav;
	}

	private JMenu createMenu(HashMap props) {
		if (props.containsKey("position")) {
      HashMap postion = (HashMap) props.get("position");
      this.nav.setBounds((int) postion.get("x"), (int) postion.get("y"), (int) postion.get("width"),
          (int) postion.get("height"));
    }
    if (props.containsKey("outline")) {
      this.nav.setOpaque(false);
    }

    if (props.containsKey("text")) {
      this.nav.setText((String) props.get("text"));
    }

    return this.nav;
	}

  public void addItem(JMenuItem item) {
    item.setForeground(Colors.get("text"));
    item.setFont(Fonts.get("primary", 18));
    this.items.add(item);
  }

  public JMenu init() {
    for (JMenuItem menu : this.items) {
      this.nav.add(menu);
    }

    return this.nav;
  }
}
