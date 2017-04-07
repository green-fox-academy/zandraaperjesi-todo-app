class Task {
  private static final long DAYS = 86400000;
  private String state;
  private String description;
  private long dueDate;

  Task(String state, String description, long dueInMillis) {
    this.state = state;
    this.description = description;
    this.dueDate = dueInMillis;
  }

  String getDescription() {
    return this.description;
  }

  String getRawForm() {
    return this.state + ";" + this.description + ";" + this.dueDate;
  }

  void markDone() {
    this.state = "done";
  }

  long getDue() {
    return (this.dueDate - System.currentTimeMillis()) / DAYS;
  }

  String getState() {
    return this.state;
  }
}