package Engine;

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

// singleton
class TimeTracker implements Tracker {
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
				}
				flowState = FLOWSTATES.STARTED;
				break;
			case FLOWSTATES.PAUSED:
				if (flowState != FLOWSTATES.RESUMED || flowState != FLOWSTATES.STARTED) {
					flag = false;
				}
				flowState = FLOWSTATES.PAUSED;
				break;
			case FLOWSTATES.RESUMED:
				if (flowState != FLOWSTATES.PAUSED) {
					flag = false;
				}
				flowState = FLOWSTATES.RESUMED;
				break;
			case FLOWSTATES.ENDED:
				if (flowState != FLOWSTATES.ENDED) {
					flag = false;
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
