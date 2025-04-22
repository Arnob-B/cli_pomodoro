package Engine;

import java.io.IOException;

/**
 * Notifier
 */
class Notification {
  static void showNotification(String title, String message) {

    ProcessBuilder builder = new ProcessBuilder(
        "notify-send",
        "-t", "2000",
        title,
        message);

    try {
      builder.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

public class Notifier extends Notification {
  static void timerStarted(String title, String message, int time_in_sec) {
    String desc = String.format("%s \nduration: %dsec \nstatus: started", message, time_in_sec);
    showNotification(title, desc);
  }

  static void timerEnded(String title, String message, int time_in_sec) {
    String desc = String.format("%s \nduration: %dsec \nstatus: ended", message, time_in_sec);
    showNotification(title, desc);
  }

}
