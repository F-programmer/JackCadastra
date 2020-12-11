package Components.UI;

import javax.swing.*;
import java.util.HashMap;

import Utils.*;

public class DefaultButton {

  private JButton btnBotao = new JButton();
  public DefaultButton() {
    this.btnBotao.setBackground(Colors.get("auxiliar"));
		this.btnBotao.setForeground(Colors.get("text"));
    this.btnBotao.setFont(Fonts.get("primary", 16));
  }
  public JButton addProps() {
    return this.btnBotao;
  }
  public JButton addProps(HashMap props) {
    // default props
    if (
      props.containsKey("position")) {
      HashMap postion = (HashMap) props.get("position");
      this.btnBotao.setBounds(
        (int) postion.get("x"),
        (int) postion.get("y"),
        (int) postion.get("width"),
        (int) postion.get("height")
      );
    }
    // only button props
    if (props.containsKey("text")) {
      this.btnBotao.setText((String) props.get("text"));
    }
    if (props.containsKey("bordered")) {
      this.btnBotao.setBorder(
        BorderFactory.createMatteBorder(2, 2, 2, 2, Colors.get("text"))
        );
    }
    if (props.containsKey("outline")) {
      this.btnBotao.setOpaque(false);
    }
    if (props.containsKey("nextButton")) {
      this.btnBotao.setBorder(null);
      this.btnBotao.setBackground(Colors.get("auxiliar"));
      this.btnBotao.setForeground(Colors.get("text"));
    }
    if (props.containsKey("cancelButton")) {
      this.btnBotao.setBackground(Colors.get("cancel"));
      this.btnBotao.setForeground(Colors.get("text"));
			this.btnBotao.setOpaque(true);
			this.btnBotao.setBorder(null);
			this.btnBotao.setFont(Fonts.get("primary", 20));
		}
		if (props.containsKey("nextButton")) {
			this.btnBotao.setBackground(Colors.get("primary"));
      this.btnBotao.setForeground(Colors.get("text"));
			this.btnBotao.setOpaque(true);
			this.btnBotao.setFont(Fonts.get("primary", 20));
		}
		if (props.containsKey("fakeInput")) {
			this.btnBotao.setOpaque(false);
			this.btnBotao.setBorder(
        BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.get("text"))
				);
			this.btnBotao.setText("");
		}

    return this.btnBotao;
  }

}
