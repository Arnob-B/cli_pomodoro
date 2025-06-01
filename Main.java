import Engine.PomodoroEngine;
import Engine.Timer;

import lib.Time;

import Engine.Notifier;
import lib.CLIManager;
import Engine.Tracker;

class Main {
	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			CLIManager.showUsage();
			return;
		}
		Time t;
		try {
			t = new Time(args[0]);
		} catch (Exception err) {
			System.out.println("invalid time format");
			CLIManager.showUsage();
			return;
		}
		String title = "start studying";
		Notifier.timerStarted("start studying", "focus for a while", t.get_TIME_IN_SEC());
		Timer timer = new Timer("timer", t.get_TIME_IN_MS(), () -> {
			Notifier.timerStarted("stop Studying", "take a break", t.get_TIME_IN_SEC());
		});
		timer.begin();
		// CLIManager cli = new CLIManager();
		// cli.printTime_in_ms(3000);
	}
}
