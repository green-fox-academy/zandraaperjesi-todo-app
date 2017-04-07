public class Task {
  static final long DAYS = 86400000;
  private String state;
  private String description;
  private long dueDate;

  public Task(String state, String description, long dueInMillis) {
    this.state = state;
    this.description = description;
    this.dueDate = dueInMillis;
  }

  public String getDescription() {
    return this.description;
  }

  public String getRawForm() {
    return this.state + ";" + this.description + ";" + this.dueDate;
  }

  public void markDone() {
    this.state = "done";
  }

  public long getDue() {
    return (this.dueDate - System.currentTimeMillis()) / DAYS;
  }

  public String getState() {
    return this.state;
  }
}