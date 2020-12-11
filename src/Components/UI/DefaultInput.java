package Components.UI;

import javax.swing.*;
import java.util.HashMap;
import java.awt.Color;
import java.awt.event.*;

import Utils.*;

public class DefaultInput {

  private JTextField inputCampo = new JTextField();

  private Color focusBorderColor = Colors.get("auxiliar");

  public DefaultInput() {
    this.inputCampo.setBackground(Colors.get("primary"));
    this.inputCampo.setForeground(Colors.get("text"));
    this.inputCampo.setFont(Fonts.get("primary", 16));
  }

  public JTextField addProps() {
    return this.inputCampo;
  }

  public JTextField addProps(HashMap props) {
    if (props.containsKey("position")) {
      HashMap postion = (HashMap) props.get("position");
      this.inputCampo.setBounds((int) postion.get("x"), (int) postion.get("y"), (int) postion.get("width"),
          (int) postion.get("height"));
    }
    if (props.containsKey("bordered")) {
      this.inputCampo.setBorder(
        BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.get("text"))
        );
    }
    if (props.containsKey("outline")) {
      this.inputCampo.setOpaque(false);
      this.focusBorderColor = Colors.get("text");
    }
    if (props.containsKey("placeholder")) {
      this.inputCampo.setText((String) props.get("placeholder"));
      this.inputCampo.addFocusListener(this.setPlaceholder((String) props.get("placeholder")));
    }

    return this.inputCampo;
  }

  public FocusListener setPlaceholder(String placeholder) {
    FocusListener onFocus = new FocusListener() {

      @Override
      public void focusLost(FocusEvent e) {
        if (inputCampo.getText().equals(""))
          inputCampo.setText(placeholder);

        inputCampo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Colors.get("text")));

      }

      @Override
      public void focusGained(FocusEvent e) {
        if (inputCampo.getText().equals(placeholder))
          inputCampo.setText("");

        inputCampo.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, focusBorderColor));
      }
    };
    return onFocus;
	}
}
