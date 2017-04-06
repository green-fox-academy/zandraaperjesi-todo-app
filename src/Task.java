public class Task {
  private String state;
  private String description;

  public Task(String state, String description) {
    this.description = description;
    this.state = state;
  }

  public String getDescription() {
    return this.description;
  }

  public String saveData() {
    return this.state + ";" + this.description;
  }

  public void markDone() {
    this.description = "done";
  }
}