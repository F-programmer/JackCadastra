package Generic;

import javax.swing.*;
import java.awt.*;

public class DefaultScreen extends JFrame{
  public Container containter = null;
  public int width = 0;
  public int height = 0;

  public DefaultScreen(
    int width,
    int height
  ) {
    this.setSize(width, height);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setLayout(null);
    this.setLocationRelativeTo(null);
  }
}
