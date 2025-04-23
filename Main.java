import Engine.PomodoroEngine;
import Engine.Timer;
import Engine.Notifier;
import lib.CLIManager;

class Main {
  public static void main(String[] args) throws Exception {
    PomodoroEngine pm = new PomodoroEngine();
    pm.start();
    String title = "start studying";
    int time_in_s = 50;
    Notifier.timerStarted("start studying", "focus for a while", time_in_s);
    Timer t = new Timer("timer", time_in_s * 1000, () -> {
      Notifier.timerStarted("stop Studying", "take a break", time_in_s);
    });
    t.begin();
    // CLIManager cli = new CLIManager();
    // cli.printTime_in_ms(3000);
  }
}
