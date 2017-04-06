public class Task {
  private String state; //can be done or undone
  private String description; //description of the t0dos

  public Task(String state, String description) {
    this.description = description;
    this.state = state;
  }

  public String getDescription() {
    return this.description;
  }
}