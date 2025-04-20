package Engine;

class Main {
  public static void main(String[] args) {
    PomodoroEngine pm = new PomodoroEngine();
    pm.start();
    int time_in_s = 2;
    Timer t = new Timer("timer", time_in_s * 1000, () -> {
      System.out.println("time has ended dosto");
    });
    t.begin();
  }
}
