package Utils;

import java.util.Timer;
import java.util.TimerTask;

public interface Delayer {

	public default boolean exec() throws Exception {
		return true;
	}

	public default void create(int delay) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				try {
					exec();
				} catch (Exception e) {
					e.printStackTrace();
				}
				timer.cancel();
			}
		};
		timer.schedule(task, delay);
		return;
	}

	public default void repeatUntil(int delay) throws Exception{
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				try {
					if (exec()) timer.cancel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		timer.schedule(task, 0, delay);
	}

}
