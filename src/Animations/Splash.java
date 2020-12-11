package Animations;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Utils.PathResolve;

public class Splash extends JPanel {
	private static final long serialVersionUID = 1L;

	private Color color;
	private int delay = 0;

	private double angulo = 0;
	private int stepCount = 0;
	private int x = 50;
	private int y = 50;
	private BufferedImage imagem;
	private TimerTask task;

	public Splash(String pathImage, int delay, String color) throws Exception {
		this.imagem = ImageIO.read(new File(PathResolve.getPath(pathImage)));
		this.delay = delay;
		this.color = Color.decode(color);

		init();
	}

	public Splash(String pathImage, int delay, Color cor) throws Exception {
		this.imagem = ImageIO.read(new File(PathResolve.getPath(pathImage)));
		this.delay = delay;
		this.color = cor;

		init();
	}

	public Splash(String pathImage, int delay, boolean invisible) throws Exception {
		this.imagem = ImageIO.read(new File(PathResolve.getPath(pathImage).replaceAll("/", "")));
		this.delay = delay;
		this.setBackground(null);
		this.setOpaque(!invisible);

		init();
	}

	public void init() {
		this.setSize(100, 100);
		this.setVisible(true);
		this.setBackground(this.color);

		this.animate();
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (g != null) {
			Graphics2D ctx = (Graphics2D) g;
			ctx.setColor(color);
			ctx.fillRect(0, 0, getSize().width, getSize().height);
			AffineTransform save = ctx.getTransform();

			ctx.translate(this.x, this.y);
			ctx.rotate(this.angulo);

			ctx.drawImage(this.imagem, -50, -50, 100, 100, this);

			ctx.setTransform(save);
		}
	}

	public void animate() {
		this.task = new TimerTask() {
			public void run() {
				angulo = Math.toRadians(30 * stepCount);
				stepCount++;
				repaint();
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 0, delay);
	}

	public void kill() {
		this.task.cancel();
	}

	public void restore() {
		this.task.cancel();
		this.task = null;
		this.animate();
	}
}
