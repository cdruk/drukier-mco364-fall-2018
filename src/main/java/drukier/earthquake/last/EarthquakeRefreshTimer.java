package drukier.earthquake.last;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class EarthquakeRefreshTimer {
    Toolkit toolkit;
    Timer timer;

    public EarthquakeRefreshTimer() {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new Refresh(),
                0,        //initial delay
                30000);  //subsequent rate
    }

    class Refresh extends TimerTask {
        public void run() {
            if (numWarningBeeps > 0) {
                toolkit.beep();
                System.out.println("Beep!");
                numWarningBeeps--;
            } else {
                toolkit.beep();
                System.out.println("Time's up!");
                //timer.cancel(); // Not necessary because
                // we call System.exit
                System.exit(0);   // Stops the AWT thread
                // (and everything else)
            }
        }
    }
}
