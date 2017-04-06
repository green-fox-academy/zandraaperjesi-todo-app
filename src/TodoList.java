import java.util.ArrayList;
import java.util.List;

public class TodoList {
  private List<Task> todos;

  public void add() {

  }

  public void delete(int index) {
    List<Task> buffer = new ArrayList<>();
    for(int i = 0; i < todos.size(); i++) {
      if (i != index) {
        buffer.add(todos.get(i));
      }
    }
    todos = buffer;
  }

  public void list() {

  }

  public void listState() {

  }

  public void markDone() {

  }
}
