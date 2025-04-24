package lib;

public class Time {
  int hour, minute, second;
  long ms;

  public Time() {
    hour = 0;
    minute = 0;
    second = 0;
  }

  public Time(String time) throws Exception {
    String timeArray[] = time.split(":");
    Exception exceptionObj = new Exception("unwanted format passed");

    if (timeArray.length != 3) {
      throw exceptionObj;
    }

    try {
      this.hour = Integer.parseInt(timeArray[0]);
      this.minute = Integer.parseInt(timeArray[1]);
      this.second = Integer.parseInt(timeArray[2]);

      if ((this.hour < 0 || this.hour > 24) ||
          (this.minute < 0 || this.minute > 60) ||
          (this.second < 0 || this.second > 60))
        throw exceptionObj;

    } catch (Exception Err) {
      throw exceptionObj;
    }

    this.ms = (hour * 60 * 60 + minute * 60 + second) * 1000;
  }

  public int get_TIME_IN_SEC() {
    return hour * 60 * 60 + minute * 60 + second;
  }

  public long get_TIME_IN_MS() {
    return this.ms;
  }

}
