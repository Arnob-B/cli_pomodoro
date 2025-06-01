package com.pomodoro;

import com.pomodoro.Engine.Timer;
import com.pomodoro.Tracker.TimeTracker;
import com.pomodoro.lib.Time;
import com.pomodoro.Engine.Notifier;
import com.pomodoro.lib.CLIManager;

class Main {
	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			CLIManager.showUsage();
			return;
		}
		String module = args[0];
		switch (module) {
			case "pomo":
				Time t;
				try {
					t = new Time(args[1]);
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
				break;
			case "tracker":
				TimeTracker tracker = new TimeTracker();
				boolean result = tracker.changeFlowState(args[1]);
				System.out.println(result);
				tracker.displayCurrentState();
				break;
			default:
				CLIManager.showUsage();
				break;
		}
	}
}
