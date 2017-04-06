import java.util.ArrayList;
import java.util.List;

public class TodoList {
  private List<Task> todos;

  public TodoList() {
    todos = new ArrayList<>();
  }

  public void add(Task taskTodo) {
    this.todos.add(taskTodo);
  }

  public void delete(int index) {
    List<Task> buffer = new ArrayList<>();
    for(int i = 0; i < todos.size(); i++) {
      if (i != index - 1) {
        buffer.add(todos.get(i));
      }
    }
    todos = buffer;
  }

  public void list() {
    int i = 0;
    for (Task t : todos) {
      if (t.getState().equals("done")) {
        System.out.println(i + " - [x] " + t.getDescription());
      }
      else {
        System.out.println(i + " - [ ] " + t.getDescription());
      }
    }
  }

  public List<String> saveToFile() {
    List<String> buffer = new ArrayList<>();
    for (Task task : todos) {
      buffer.add(task.saveData());
    }
    return buffer;
  }

  public void listState() {

  }

  public void markDone(int toMark) {
    this.todos.get(toMark - 1).markDone();
  }
}
