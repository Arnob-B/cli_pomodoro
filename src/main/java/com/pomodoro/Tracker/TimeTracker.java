package com.pomodoro.Tracker;

import com.pomodoro.Tracker.Tracker;
import java.util.Date;

public class TimeTracker implements Tracker {
	public String flowState = null;

	public TimeTracker() {
		flowState = FLOWSTATES.STARTED;
	}

	public void writeChanges() {
		System.out.println("state changed to " + flowState + " at " + new Date().getTime());
	}

	public boolean changeFlowState(String newState) {
		boolean flag = true;
		switch (newState) {
			case FLOWSTATES.STARTED:
				if (flowState != FLOWSTATES.ENDED) {
					flag = false;
					break;
				}
				flowState = FLOWSTATES.STARTED;
				break;
			case FLOWSTATES.PAUSED:
				if (flowState != FLOWSTATES.RESUMED || flowState != FLOWSTATES.STARTED) {
					flag = false;
					break;
				}
				flowState = FLOWSTATES.PAUSED;
				break;
			case FLOWSTATES.RESUMED:
				if (flowState != FLOWSTATES.PAUSED) {
					flag = false;
					break;
				}
				flowState = FLOWSTATES.RESUMED;
				break;
			case FLOWSTATES.ENDED:
				if (flowState != FLOWSTATES.ENDED) {
					flag = false;
					break;
				}
				flowState = FLOWSTATES.ENDED;
				break;
			default:
				System.out.println("invalid state passed");
				flag = false;
				break;
		}
		if (!flag)
			return false;
		writeChanges();
		return true;
	}

	public void displayCurrentState() {
		System.out.println("current flow state : " + flowState);
	}
}
