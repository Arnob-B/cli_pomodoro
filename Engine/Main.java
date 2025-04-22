package Engine;

class Main {
  public static void main(String[] args) {
    PomodoroEngine pm = new PomodoroEngine();
    pm.start();
    String title = "start studying";
    int time_in_h = 1;
    int time_in_s = time_in_h * 60 * 60;
    Notifier.timerStarted("start studying", "focus for a while", time_in_s);
    Timer t = new Timer("timer", time_in_s * 1000, () -> {
      Notifier.timerEnded("start studying", "take some break", time_in_s);
    });
    t.begin();
  }
}
