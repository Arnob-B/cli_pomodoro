package DB;

public class DBManager {
	String connectionStatus = "NOT_CONNECTED";

	public DBManager(String DBURI) {
		System.out.println(DBURI + " loggedin in");
		connectionStatus = "CONNECTED";
	}

	public String status() {
		return connectionStatus;
	}
}
