import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Test03 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println(LocalDateTime.now());
			}
		};
		timer.scheduleAtFixedRate(task, 0, 2000);
	}
}
