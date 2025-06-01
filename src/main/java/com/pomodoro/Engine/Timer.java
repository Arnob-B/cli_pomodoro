package com.pomodoro.Engine;

import java.util.*;
import com.pomodoro.lib.CLIManager;

class CurrentTimerTime {
	public long total_sec_in_ms;
	public long current_sec_in_ms;

	CurrentTimerTime(long total_time_in_ms, long time_elapsed_in_ms) {
		this.total_sec_in_ms = total_time_in_ms;
		this.current_sec_in_ms = time_elapsed_in_ms;
	}
}

public class Timer extends Thread {
	public interface TimerListerner {
		void onTimeEnd();
	}

	String name;
	long starting_time_in_ms;
	long ending_time_in_ms;
	long total_time_in_ms;
	long counter_in_ms;
	TimerListerner listener;
	final long STEP_FOR_SLEEP = 10;
	CLIManager cli;

	public Timer(String name, long total_time_in_ms, TimerListerner listener) {
		cli = new CLIManager();
		this.listener = listener;
		this.name = name;
		// this.listener = new TimerListerner();
		Date localDate = new Date();
		this.starting_time_in_ms = localDate.getTime();
		this.total_time_in_ms = total_time_in_ms;
		this.counter_in_ms = total_time_in_ms;
	}

	public void begin() {
		System.out.println("timer started for " + total_time_in_ms + "ms");
		start();
	}

	public CurrentTimerTime getCurrentTime() {
		long elapsed = total_time_in_ms - counter_in_ms;
		return new CurrentTimerTime(total_time_in_ms, elapsed);
	}

	public void end() {
		System.out.println("timer stopped for " + total_time_in_ms + "ms");
		this.ending_time_in_ms = starting_time_in_ms + total_time_in_ms - counter_in_ms;
	}

	public void run() {
		try {
			while (counter_in_ms != 0) {
				counter_in_ms -= STEP_FOR_SLEEP;
				// System.out.println(counter_in_ms);
				cli.printTime_in_ms(counter_in_ms);
				Thread.sleep(STEP_FOR_SLEEP);
			}
			System.out.println();
			listener.onTimeEnd();
			this.end();
		} catch (Exception err) {
			System.out.println("error -> " + err);
			this.end();
		}
	}

}
