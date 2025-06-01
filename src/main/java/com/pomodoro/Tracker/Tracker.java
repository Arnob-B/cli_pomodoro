package com.pomodoro.Tracker;

import java.util.Date;

final class FLOWSTATES {
	final static String PAUSED = "PAUSED";
	final static String RESUMED = "RESUMED";
	final static String STARTED = "STARTED";
	final static String ENDED = "ENDED";
}

public interface Tracker {

	public boolean changeFlowState(String newState);

}
