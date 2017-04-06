public class Task {
  private String state;
  private String description;

  public Task(String state, String description) {
    this.state = state;
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }

  public String saveData() {
    return this.state + ";" + this.description;
  }

  public void markDone() {
    this.state = "done";
  }

  public String getState() {
    return this.state;
  }
}