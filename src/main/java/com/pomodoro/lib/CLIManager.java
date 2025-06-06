
/**
 * CLIManager
 */
package com.pomodoro.lib;

import java.io.BufferedReader;
import java.io.InputStreamReader;

interface CLI_TIME {
	default public void counter(int hour, int min, int sec) throws InterruptedException {
		while (true) {
			System.out.printf("\r%02d:%02d:%02d", hour, min, sec);
			if (sec == 0) {
				if (min == 0) {
					if (hour == 0)
						return;
					hour--;
					min = 60;
					sec = 60;
				} else {
					min--;
					sec = 60;
				}
			} else {
				sec--;
			}
			Thread.sleep(1000);
		}
	}

	public default void printTime(int hour, int min, int sec) {
		String time = String.format("\r%02d:%02d:%02d", hour, min, sec);
		System.out.printf(time);
	}

	public default void printTimeFancy(int hour, int min, int sec) {
		try {
			String time = String.format("%02d:%02d:%02d", hour, min, sec);

			ProcessBuilder pb = new ProcessBuilder("figlet", time);
			Process process = pb.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			// Clear screen using ANSI escape code
			System.out.print("\033[H\033[2J");
			System.out.flush();

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	default public void printTime_in_ms(long millisec) throws InterruptedException {
		long totalSeconds = millisec / 1000;
		int sec = (int) (totalSeconds % 60);
		int min = (int) ((totalSeconds / 60) % 60);
		int hour = (int) (totalSeconds / 3600);
		this.printTime(hour, min, sec);
		// counter(hour, min, sec);
	}

	default public void count_time_in_ms(long millisec) throws InterruptedException {
		long totalSeconds = millisec / 1000;
		int sec = (int) (totalSeconds % 60);
		int min = (int) ((totalSeconds / 60) % 60);
		int hour = (int) (totalSeconds / 3600);
		counter(hour, min, sec);
	}

}

public class CLIManager implements CLI_TIME {
	public static void showUsage() {
		System.out.println("--- pomodoro ---");
		System.out.println("pomo 00:00:00");
		System.out.println("tracker start/resume/pause/stop");
	}

	public static void loader() throws InterruptedException {
		while (true) {
			System.out.printf("\r[   ]");
			Thread.sleep(100);
			System.out.printf("\r[#  ]");
			Thread.sleep(100);
			System.out.printf("\r[## ]");
			Thread.sleep(100);
			System.out.printf("\r[###]");
			Thread.sleep(100);
		}

	}
}
