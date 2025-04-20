import Engine.PomodoroEngine;
import Engine.Timer;
import DB.DBManager;

class Main {
  public static void main(String[] args) {
    PomodoroEngine pm = new PomodoroEngine();
    int time_in_s = 20;
    Timer t = new Timer("timer", time_in_s * 1000);
    t.begin();
    DBManager db = new DBManager("hello");
    System.out.println(db.status());
    pm.start();
  }
}
